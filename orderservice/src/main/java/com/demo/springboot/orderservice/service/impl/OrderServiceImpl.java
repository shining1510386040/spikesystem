package com.demo.springboot.orderservice.service.impl;

import com.demo.springboot.orderservice.dao.TicketOrderMapper;
import com.demo.springboot.orderservice.entity.TicketOrder;
import com.demo.springboot.orderservice.entity.TicketOrderExample;
import com.demo.springboot.orderservice.service.OrderService;
import com.demo.springboot.orderservice.utils.CommonUtils;
import com.demo.springboot.orderservice.vo.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 订单服务
 * @date 2021/4/20 14:46
 * @see
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TicketOrderMapper ticketOrderMapper;

    @Override
    public ServiceResult createOrder(TicketOrder order) {
        // 设置pk
        order.setOrderId(CommonUtils.generateRecordId("order"));
        int insert = ticketOrderMapper.insert(order);
        ServiceResult ret = new ServiceResult("200", "创建订单成功");
        ret.setData(insert);
        return ret;
    }

    @Override
    public ServiceResult pageOrder(TicketOrder condition, Integer pageNo, Integer pageSize) {

        TicketOrderExample example = new TicketOrderExample();
        TicketOrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdIsNotNull();
        example.setLimitStart((pageNo - 1) * pageSize);
        example.setLimitSize(pageSize);
        List<TicketOrder> ticketOrders = ticketOrderMapper.selectByExample(example);
        ServiceResult ret = new ServiceResult("200", "查询成功");
        ret.setData(ticketOrders);
        return ret;
    }

    @Override
    public ServiceResult getDetail(String orderId) {
        TicketOrder ticketOrder = ticketOrderMapper.selectByPrimaryKey(orderId);
        ServiceResult ret = new ServiceResult("200", "查询成功");
        ret.setData(ticketOrder);
        return ret;
    }

    @Override
    public ServiceResult updateOrderStatus(String orderId, Integer status) {
        TicketOrder order = new TicketOrder();
        order.setOrderId(orderId);
        order.setStatus(status);
        int i = ticketOrderMapper.updateByPrimaryKeySelective(order);
        ServiceResult ret = new ServiceResult("200", "更新状态成功");
        ret.setData(i);
        return ret;
    }
}
