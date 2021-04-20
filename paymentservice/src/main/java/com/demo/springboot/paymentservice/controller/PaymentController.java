package com.demo.springboot.paymentservice.controller;

import com.demo.springboot.paymentservice.entity.TicketPayment;
import com.demo.springboot.paymentservice.service.PaymentService;
import com.demo.springboot.paymentservice.vo.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 支付服务
 * @date 2021/4/20 18:21
 * @see
 */
@RestController
@RequestMapping("/pay")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping("/test")
    public ServiceResult testPay(TicketPayment payment, @RequestParam String orderId) {
        return paymentService.testPay(payment, orderId);
    }

}
