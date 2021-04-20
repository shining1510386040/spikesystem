package com.demo.springboot.storeservice.service;

import com.demo.springboot.storeservice.entity.TicketStore;
import com.demo.springboot.storeservice.vo.ServiceResult;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 库存服务接口
 * @date 2021/4/20 18:45
 * @see
 */
public interface StoreService {

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 保存一个库存
     * @date 2021/4/20 18:46
     */
    ServiceResult saveStore(TicketStore store);

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 扣减库存
     * @date 2021/4/20 18:47
     */
    ServiceResult decreaseStore(TicketStore store, String productId, Integer num);

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 查询库存
     * @date 2021/4/20 18:48
     */
    ServiceResult pageStore(TicketStore condition, Integer pageNo, Integer pageSize);
}
