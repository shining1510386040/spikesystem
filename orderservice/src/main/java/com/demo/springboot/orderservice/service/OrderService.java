package com.demo.springboot.orderservice.service;

import com.demo.springboot.orderservice.entity.TicketOrder;
import com.demo.springboot.orderservice.vo.ServiceResult;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 订单操作相关接口
 * @date 2021/4/20 14:41
 * @see
 */
public interface OrderService {

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 创建订单
     * @date 2021/4/20 14:42
     */
    ServiceResult createOrder(TicketOrder order);

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 分页查询
     * @date 2021/4/20 14:44
     */
    ServiceResult pageOrder(TicketOrder condition, Integer pageNo, Integer pageSize);

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 查看订单详情
     * @date 2021/4/20 14:44
     */
    ServiceResult getDetail(String orderId);

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 更新订单状态
     * @date 2021/4/20 14:45
     */
    ServiceResult updateOrderStatus(String orderId, Integer status);
}
