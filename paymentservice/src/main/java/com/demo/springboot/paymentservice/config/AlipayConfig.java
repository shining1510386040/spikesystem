package com.demo.springboot.paymentservice.config;

import org.springframework.stereotype.Component;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 支付宝支付配置
 * @date 2021/4/21 14:33
 * @see
 */
@Component
public class AlipayConfig {

    // 应用ID,您的APPID,收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "您的APPID";

    // 商户私钥，
    public static String APP_PRIVATE_KEY = "您的PKCS8格式RSA2私钥";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "您的支付宝公钥";

    // 服务器异步通知页面路径,需http://格式的完整路径，不能加自定义参数，必须外网可以正常访问
    /**
     * @author Wenyi Cao
     * @version 1.0
     * @description 回调
     * @date 2021/4/21 15:16
     * @param
     * @return
     */
    public static String notify_url = "";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能自定义参数，支付成功后返回的页面
    /**
     * @author Wenyi Cao
     * @version 1.0
     * @description 支付完成跳转页
     * @date 2021/4/21 15:17
     * @param
     * @return
     */
    public static String return_url = "http://localhost:8080/returnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    // public static String log_path = "https://openapi.alipay.com/gateway.do";

}
