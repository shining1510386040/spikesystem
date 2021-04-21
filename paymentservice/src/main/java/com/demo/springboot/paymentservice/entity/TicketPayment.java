package com.demo.springboot.paymentservice.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 这是MyBatis Generator自动生成的Model Class.
 * 对应的数据表是 : tbl_ticket_payment
 *
 * @author Lenovo
 * @date 2021-04-20 14:29:58
 */
@Data
@ToString
public class TicketPayment implements Serializable {
    /**
     * 主键：支付记录id
     */
    private String paymentId;

    /**
     * 类型：微信、支付宝、银联支付
     */
    private String paymentType;

    /**
     * 支付金额
     */
    private BigDecimal paymentMoney;

    /**
     * 支付的订单
     */
    private String orderId;

    private String appId;

    private String payStatus;

    private String tradeStatus;

    private String body;


    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改人
     */
    private String modifyBy;

    /**
     * 修改时间
     */
    private Date modifyDate;

    private static final long serialVersionUID = 1L;

}