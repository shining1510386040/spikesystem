package com.demo.springboot.orderservice.controller;

import com.demo.springboot.orderservice.entity.TicketOrder;
import com.demo.springboot.orderservice.service.OrderService;
import com.demo.springboot.orderservice.vo.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 订单controller
 * @date 2021/4/20 15:00
 * @see
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ServiceResult createOrder(TicketOrder order) {
        return orderService.createOrder(order);
    }
}
