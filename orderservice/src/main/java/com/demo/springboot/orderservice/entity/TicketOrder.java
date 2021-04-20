package com.demo.springboot.orderservice.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 这是MyBatis Generator自动生成的Model Class.
 * 对应的数据表是 : tbl_ticket_order
 * @author Lenovo
 * @date 2021-04-20 14:29:58
 */
public class TicketOrder implements Serializable {
    /**
     * 主键：订单id
     */
    private String orderId;

    /**
     * 订单明细
     */
    private String orderItems;

    /**
     * 订单总金额
     */
    private BigDecimal orderPrice;

    /**
     * 订单优惠后金额
     */
    private BigDecimal orderVipPrice;

    /**
     * 订单购买的商品
     */
    private String orderProduct;

    /**
     * 订单商品数量
     */
    private Integer orderProductNum;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 上次修改人
     */
    private String modifyBy;

    /**
     * 上次修改日期
     */
    private Date modifyDate;

    /**
     * 订单状态：0新创建，1已支付
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(String orderItems) {
        this.orderItems = orderItems == null ? null : orderItems.trim();
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getOrderVipPrice() {
        return orderVipPrice;
    }

    public void setOrderVipPrice(BigDecimal orderVipPrice) {
        this.orderVipPrice = orderVipPrice;
    }

    public String getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(String orderProduct) {
        this.orderProduct = orderProduct == null ? null : orderProduct.trim();
    }

    public Integer getOrderProductNum() {
        return orderProductNum;
    }

    public void setOrderProductNum(Integer orderProductNum) {
        this.orderProductNum = orderProductNum;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", orderItems=").append(orderItems);
        sb.append(", orderPrice=").append(orderPrice);
        sb.append(", orderVipPrice=").append(orderVipPrice);
        sb.append(", orderProduct=").append(orderProduct);
        sb.append(", orderProductNum=").append(orderProductNum);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyBy=").append(modifyBy);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}