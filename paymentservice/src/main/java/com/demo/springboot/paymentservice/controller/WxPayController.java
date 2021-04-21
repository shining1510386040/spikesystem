package com.demo.springboot.paymentservice.controller;

import com.demo.springboot.paymentservice.config.WechatPayConfig;
import com.demo.springboot.paymentservice.service.WechatPayService;
import com.demo.springboot.paymentservice.utils.WechatPayUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

/**
 * @author Wenyi Cao
 * @version 1.0
 * @link
 * @description 微信支付-生成二维码和统一下单回调函数
 * @date 2021/4/21 10:57
 * @see
 */
@RestController
@RequestMapping("/wxPay")
public class WxPayController {

    @Autowired
    private WechatPayService wxPayService;

    @Autowired
    private WechatPayConfig wxPayConfig;

    /**
     * 微信支付 生成二维码
     *
     * @param money
     * @return
     */
    @GetMapping("/pay")
    public void wxPay(String money, HttpServletResponse response) {
        String body = "套餐描述";
        Double amount = 0.01;
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderNo = date.format(new Date()) + WechatPayUtils.getCurrentTimestampMs();
        String url_code = wxPayService.save(orderNo, amount, body);

        if (url_code == null) {
            throw new NullPointerException();
        }

        try {
            // 生成二维码配置
            Map<EncodeHintType, Object> hints = new HashMap<>();
            // 设置纠错等级
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            // 编码类型
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            BitMatrix bitMatrix = new MultiFormatWriter().encode(url_code, BarcodeFormat.QR_CODE, 400, 400, hints);
            OutputStream outputStream = response.getOutputStream();

            MatrixToImageWriter.writeToStream(bitMatrix, "png", outputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 微信支付回调接口
     */
    @RequestMapping("/callback")
    public void OrderCallBack(HttpServletRequest request, HttpServletResponse response) {
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            // BufferedReader是包装设计模式，性能更高
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            bufferedReader.close();
            inputStream.close();
            Map<String, String> callBackMap = WechatPayUtils.xmlToMap(stringBuffer.toString());
            System.out.println(callBackMap.toString());

            SortedMap<String, String> sortedMap = WechatPayUtils.getSortedMap(callBackMap);
            // 校验签名是否正确
            if (WechatPayUtils.isCorrectSign(sortedMap, wxPayConfig.getKey())) {
                System.out.println("签名校验成功！");
                // 更新订单状态
                if ("SUCCESS".equals(sortedMap.get("result_code"))) {
                    String outTradeNo = sortedMap.get("out_trade_no"); // 流水号
                    String totalFee = sortedMap.get("total_fee"); // 交易金额
                    if (wxPayService.callBackPayUpdate(outTradeNo, totalFee)) {    // 通知微信订单处理成功
                        response.setContentType("text/xml");
                        response.getWriter().println("success");
                        return;
                    }
                }
                // 未成功，就都处理为失败订单
                response.setContentType("text/html");
                response.getWriter().println("fail");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
