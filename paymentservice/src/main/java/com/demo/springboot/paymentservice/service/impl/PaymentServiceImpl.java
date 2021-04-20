package com.demo.springboot.paymentservice.service.impl;

import com.demo.springboot.paymentservice.dao.TicketPaymentMapper;
import com.demo.springboot.paymentservice.entity.TicketPayment;
import com.demo.springboot.paymentservice.service.PaymentService;
import com.demo.springboot.paymentservice.utils.CommonUtils;
import com.demo.springboot.paymentservice.vo.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 支付服务
 * @date 2021/4/20 18:30
 * @see
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private TicketPaymentMapper ticketPaymentMapper;

    @Override
    public ServiceResult selectWay(String type) {

        // todo
        return null;
    }

    @Override
    public ServiceResult payWithWechat(TicketPayment payment, String orderId) {
        // todo

        return null;
    }

    @Override
    public ServiceResult payAlipay(TicketPayment payment, String orderId) {
        // todo

        return null;
    }

    @Override
    public ServiceResult payWithBank(TicketPayment payment, String orderId) {
        // todo

        return null;
    }

    @Override
    public ServiceResult testPay(TicketPayment payment, String orderId) {
        // todo 1.支付
        // 2.生成支付记录
        payment.setPaymentId(CommonUtils.generateRecordId("pay"));
        payment.setOrderId(orderId);
        int insert = ticketPaymentMapper.insert(payment);
        ServiceResult ret = new ServiceResult("200", "支付成功");
        ret.setData(insert);
        return ret;
    }
}
