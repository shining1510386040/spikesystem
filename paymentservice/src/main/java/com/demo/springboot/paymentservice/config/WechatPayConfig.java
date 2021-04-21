package com.demo.springboot.paymentservice.config;

import com.github.wxpay.sdk.WXPayConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 微信支付配置
 * @date 2021/4/21 10:00
 * @see
 */
@Component
@ConfigurationProperties(prefix = "pay.wxpay.app")
@Data
public class WechatPayConfig implements WXPayConfig {

    /**
     * appID
     */
    private String appID;

    /**
     * 商户号
     */
    private String mchID;

    /**
     * API 密钥
     */
    private String key;

    /**
     * API证书绝对路径 (本项目放在了 resources/cert/wxpay/apiclient_cert.p12")
     */
    private String certPath;

    /**
     * HTTP(S) 连接超时时间，单位毫秒
     */
    private int httpConnectTimeoutMs = 8000;

    /**
     * HTTP(S) 读数据超时时间，单位毫秒
     */
    private int httpReadTimeoutMs = 10000;

    /**
     * 微信支付异步通知地址
     */
    private String payNotifyUrl;

    /**
     * 微信退款异步通知地址
     */
    private String refundNotifyUrl;

    /**
     * 统一下单url
     */
    public static final String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    /**
     * 获取商户证书内容（这里证书需要到微信商户平台进行下载）
     *
     * @return 商户证书内容
     */
    @Override
    public InputStream getCertStream() {
        InputStream certStream = getClass().getClassLoader().getResourceAsStream(certPath);
        return certStream;
    }
}
