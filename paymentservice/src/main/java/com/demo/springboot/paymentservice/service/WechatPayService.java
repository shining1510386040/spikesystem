package com.demo.springboot.paymentservice.service;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 微信支付服务接口
 * @date 2021/4/21 10:22
 * @see
 */
public interface WechatPayService {

    /**
     * @param orderNo 订单编号
     * @param amount  订单金额
     * @param body
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 下单并支付
     * @date 2021/4/21 10:28
     */
    String save(String orderNo, double amount, String body);

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 微信支付-回调，修改交易状态
     * @date 2021/4/21 11:02
     */
    boolean callBackPayUpdate(String outTradeNo, String totalFee);
}
