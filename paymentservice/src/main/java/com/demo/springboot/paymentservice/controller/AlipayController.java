package com.demo.springboot.paymentservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.demo.springboot.paymentservice.config.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 支付宝支付controller
 * @date 2021/4/21 15:07
 * @see
 */
@Controller
@RequestMapping("/aliPay")
public class AlipayController {


    @Autowired
    private AlipayConfig alipayConfig;

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 电脑网站支付：跳转到支付宝收银台，完成支付后返回商户页面
     * @date 2021/4/21 15:11
     */
    @PostMapping("/pay")
    @ResponseBody
    public void pay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.sign_type);

        // 设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        // 返回的url
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        //
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        // 商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("out_trade_no");
        // 付款金额，必填
        String total_amount = request.getParameter("total_amount");
        // 订单名称，必填
        String subject = request.getParameter("subject");
        // 商品描述，可空
        String body = request.getParameter("body");

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        // 请求
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
            System.out.println("form==>" + form);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
        // 直接将完整的表单html输出到页面
        response.getWriter().write(form);
        response.getWriter().flush();
        response.getWriter().close();
    }

    /**
     * @param
     * @return
     * @author Wenyi Cao
     * @version 1.0
     * @description 支付宝支付完成-回调接口
     * @date 2021/4/21 15:14
     */
    @RequestMapping("/returnCall")
    public String returnCall(HttpServletRequest request, HttpSession session, Model model) throws Exception {
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println("\n验签开始.....\n");

        //调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.sign_type);

        if (signVerified) {
            // 交易编号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            Map<String, Object> outTradeNoMap = new HashMap();
            outTradeNoMap.put("out_trade_no", out_trade_no);

//            String result = HttpClientUtil.doPost(Constants.ALIPAY_TRADE_QUERY_URL, outTradeNoMap);
            // todo ...
            String result = "";
            System.out.println("验签输出==>" + result);

            Map<String, Object> resultMap = (Map<String, Object>) JSONObject.parse(result);

            if (!ObjectUtils.isEmpty(resultMap)) {

                Map<String, String> alipayTradeQueryResponse = (Map<String, String>) resultMap.get("alipay_trade_query_response");

                // ObjectUtils为lang3工具类，可自行导入相关依赖
                if (!ObjectUtils.isEmpty(alipayTradeQueryResponse)) {
                    String code = alipayTradeQueryResponse.get("code");
                    String msg = alipayTradeQueryResponse.get("msg");
                    /**
                     * 判断支付状态
                     * WAIT_BUYER_PAY，等待买家付款
                     * TRADE_CLOSED，支付超时，关闭订单
                     * TRADE_FINISHED，交易结束
                     * TRADE_SUCCESS，支付成功
                     */
                } else {
                    throw new RuntimeException("网络异常");
                }
            }
        }
        return "";
    }
}
