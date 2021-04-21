package com.demo.springboot.orderservice.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.springboot.orderservice.dao.TicketOrderMapper;
import com.demo.springboot.orderservice.entity.TicketOrder;
import com.demo.springboot.orderservice.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description order_topic主题，消费者
 * @date 2021/4/21 15:40
 * @see
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "order_topic", consumerGroup = "order_group")
public class RocketMQConsumer implements RocketMQListener<String> {

    @Autowired
    private TicketOrderMapper ticketOrderMapper;

    @Override
    public void onMessage(String message) {

        log.info("=============>>>消费到消息：" + message);
        // json -> javaBean
        JSONObject map = JSON.parseObject(message);
        String productId = map.get("productId") + "";
        Integer num = Integer.valueOf(map.get("num") + "");
        // 创建订单
        TicketOrder order = new TicketOrder();
        order.setOrderItems("购买苹果手机和笔记本电话");
        order.setStatus(0);
        order.setOrderPrice(BigDecimal.valueOf(1234));
        order.setOrderProductNum(num);
        order.setOrderVipPrice(BigDecimal.valueOf(2344));
        order.setOrderProduct(productId);


        order.setOrderId(CommonUtils.generateRecordId("order"));
        ticketOrderMapper.insert(order);

    }
}
