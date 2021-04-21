package com.demo.springboot.paymentservice.service.impl;

import com.demo.springboot.paymentservice.config.WechatPayConfig;
import com.demo.springboot.paymentservice.dao.TicketPaymentMapper;
import com.demo.springboot.paymentservice.entity.TicketPayment;
import com.demo.springboot.paymentservice.entity.TicketPaymentExample;
import com.demo.springboot.paymentservice.service.PaymentService;
import com.demo.springboot.paymentservice.service.WechatPayService;
import com.demo.springboot.paymentservice.utils.HttpClientUtil;
import com.demo.springboot.paymentservice.utils.WechatPayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 微信支付实现
 * @date 2021/4/21 10:23
 * @see
 */
@Service
public class WechatPayServiceImpl implements WechatPayService {

    @Autowired
    private WechatPayConfig wechatPayConfig;

    @Autowired
    private TicketPaymentMapper ticketPaymentMapper;

    @Override
    public String save(String orderNo, double amount, String body) {

//        Integer uid = ShiroKit.getUser().getId();
        // 当前登录的用户id:可集成shiro获取
        Integer userId = 123;
        // 1. 生成订单
        // 订单号，流水号，金额，付款状态，创建时间
        String product_id = WechatPayUtils.generateUUID();
        TicketPayment payment = new TicketPayment();
        // 交易支付流水号
        payment.setPaymentId(product_id);
        // 订单id（微信支付交易号）
        payment.setOrderId(orderNo);
        //交易金额
        payment.setPaymentMoney(BigDecimal.valueOf(amount));
        // 当前操作人
        payment.setCreateBy(userId + "");
        payment.setCreateDate(new Date());
        // 公众号id
        payment.setAppId(wechatPayConfig.getAppID());
        // 交易状态（支付流水-支付记录）
        payment.setTradeStatus("0");
        // 支付状态（异步回调时更改此状态）
        payment.setPayStatus("0");
        // 交易其他信息
        payment.setBody(body);
        // 交易类型：微信支付
        payment.setPaymentType("wechat");
        ticketPaymentMapper.insert(payment);
        // 2.调用统一下单方法，返回 codeUrl 地址
        String codeUrl = unifiedOrder(product_id, orderNo, amount, body);

        return codeUrl;
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 统一下单
     * @date 2021/4/21 10:50
     */
    private String unifiedOrder(String product_id, String orderNo, double amount, String body) {
        // 生成签名
        try {
            SortedMap<String, String> params = new TreeMap<>();
            params.put("appid", wechatPayConfig.getAppID());
            params.put("mch_id", wechatPayConfig.getMchID());
            params.put("nonce_str", WechatPayUtils.generateUUID());
            // 商品描述
            params.put("body", body);
            // 商户订单号
            params.put("out_trade_no", orderNo);
            // 标价金额（单位为分）
            params.put("total_fee", String.valueOf((int) (amount * 100)));
            // 终端IP
            params.put("spbill_create_ip", "外网可以访问的 ip 地址");
            // 异步接收微信支付结果通知的回调地址
            params.put("notify_url", wechatPayConfig.getPayNotifyUrl());
            // 交易类型
            params.put("trade_type", "NATIVE");
            // 微信支付要求NATIVE支付，此参数必填
            params.put("product_id", product_id);

            // sign 签名
            String sign = WechatPayUtils.createSign(params, wechatPayConfig.getKey());
            params.put("sign", sign);
            System.out.println(sign);

            // map转xml
            String payXml = WechatPayUtils.mapToXml(params);
            System.out.println(payXml);

            // 统一下单
            String s = HttpClientUtil.doPost(WechatPayConfig.UNIFIED_ORDER_URL, payXml, 10000);
            if (null == s) {
                return null;
            }
            Map<String, String> unifiedOrderMap = WechatPayUtils.xmlToMap(s);
            System.out.println(unifiedOrderMap.toString());
            if (unifiedOrderMap != null) {
                // 前台添加定时器，进行轮询操作，直到支付完毕
                return unifiedOrderMap.get("code_url");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean callBackPayUpdate(String outTradeNo, String totalFee) {

        // 一些回调：修改，比如修改支付状态，实际支付金额等等
        TicketPayment record = new TicketPayment();
        // 已支付
        record.setPayStatus("1");

        // where 条件
        TicketPaymentExample example = new TicketPaymentExample();
        TicketPaymentExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(outTradeNo);
        int i = ticketPaymentMapper.updateByExampleSelective(record, example);
        return i > 0;
    }
}


