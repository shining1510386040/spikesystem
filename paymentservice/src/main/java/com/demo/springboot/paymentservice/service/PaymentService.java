package com.demo.springboot.paymentservice.service;

import com.demo.springboot.paymentservice.entity.TicketPayment;
import com.demo.springboot.paymentservice.vo.ServiceResult;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 支付服务接口
 * @date 2021/4/20 18:26
 * @see
 */
public interface PaymentService {

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 选择支付渠道
     * @date 2021/4/20 18:27
     */
    ServiceResult selectWay(String type);

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 微信支付
     * @date 2021/4/20 18:28
     */
    ServiceResult payWithWechat(TicketPayment payment, String orderId);

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 支付宝支付
     * @date 2021/4/20 18:28
     */
    ServiceResult payAlipay(TicketPayment payment, String orderId);

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 银联支付
     * @date 2021/4/20 18:28
     */
    ServiceResult payWithBank(TicketPayment payment, String orderId);


    ServiceResult testPay(TicketPayment payment, String orderId);

}
