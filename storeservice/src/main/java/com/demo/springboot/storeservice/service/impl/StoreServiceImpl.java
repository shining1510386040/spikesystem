package com.demo.springboot.storeservice.service.impl;

import com.demo.springboot.storeservice.dao.TicketStoreMapper;
import com.demo.springboot.storeservice.entity.TicketStore;
import com.demo.springboot.storeservice.entity.TicketStoreExample;
import com.demo.springboot.storeservice.service.StoreService;
import com.demo.springboot.storeservice.utils.CommonUtils;
import com.demo.springboot.storeservice.vo.ServiceResult;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 库存服务
 * @date 2021/4/20 18:49
 * @see
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private TicketStoreMapper ticketStoreMapper;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private LoadingCache ticketStoreCache;

    @Override
    public ServiceResult saveStore(TicketStore store) {
        store.setProductId(CommonUtils.generateRecordId("product"));
        int insert = ticketStoreMapper.insert(store);
        ServiceResult ret = new ServiceResult("200", "保存成功");
        ret.setData(insert);
        return ret;
    }

    @Override
    public ServiceResult decreaseStore(TicketStore store, String productId, Integer num) {

        // todo  ...
        // 1.本地内存扣减库存
        AtomicInteger cache = AtomicInteger.class.cast(ticketStoreCache.get(productId));
        ticketStoreCache.put(productId, new AtomicInteger(cache.get() - num));
        // 2.redis 统一扣减库存
        redisTemplate.opsForValue().decrement(productId, num);
        // 3.发送异步消息：创建订单
        Map<String, Object> msg = new HashMap<>(2);
        msg.put("productId", productId);
        msg.put("num", num);
        rocketMQTemplate.syncSend("order_topic", msg);
        return new ServiceResult("200", "扣减库存成功");
    }

    @Override
    public ServiceResult pageStore(TicketStore condition, Integer pageNo, Integer pageSize) {

        TicketStoreExample example = new TicketStoreExample();
        TicketStoreExample.Criteria criteria = example.createCriteria();
        criteria.andProductIdIsNotNull();
        example.setLimitStart((pageNo - 1) * pageSize);
        example.setLimitSize(pageSize);
        List<TicketStore> ticketStores = ticketStoreMapper.selectByExample(example);
        PageImpl data = new PageImpl(ticketStores);
        ServiceResult ret = new ServiceResult("200", "查询成功");
        ret.setData(data);
        return ret;
    }
}
