package com.demo.springboot.orderservice.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitSize;

    public TicketOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart = limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitSize(Integer limitSize) {
        this.limitSize = limitSize;
    }

    public Integer getLimitSize() {
        return limitSize;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderItemsIsNull() {
            addCriterion("order_items is null");
            return (Criteria) this;
        }

        public Criteria andOrderItemsIsNotNull() {
            addCriterion("order_items is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItemsEqualTo(String value) {
            addCriterion("order_items =", value, "orderItems");
            return (Criteria) this;
        }

        public Criteria andOrderItemsNotEqualTo(String value) {
            addCriterion("order_items <>", value, "orderItems");
            return (Criteria) this;
        }

        public Criteria andOrderItemsGreaterThan(String value) {
            addCriterion("order_items >", value, "orderItems");
            return (Criteria) this;
        }

        public Criteria andOrderItemsGreaterThanOrEqualTo(String value) {
            addCriterion("order_items >=", value, "orderItems");
            return (Criteria) this;
        }

        public Criteria andOrderItemsLessThan(String value) {
            addCriterion("order_items <", value, "orderItems");
            return (Criteria) this;
        }

        public Criteria andOrderItemsLessThanOrEqualTo(String value) {
            addCriterion("order_items <=", value, "orderItems");
            return (Criteria) this;
        }

        public Criteria andOrderItemsLike(String value) {
            addCriterion("order_items like", value, "orderItems");
            return (Criteria) this;
        }

        public Criteria andOrderItemsNotLike(String value) {
            addCriterion("order_items not like", value, "orderItems");
            return (Criteria) this;
        }

        public Criteria andOrderItemsIn(List<String> values) {
            addCriterion("order_items in", values, "orderItems");
            return (Criteria) this;
        }

        public Criteria andOrderItemsNotIn(List<String> values) {
            addCriterion("order_items not in", values, "orderItems");
            return (Criteria) this;
        }

        public Criteria andOrderItemsBetween(String value1, String value2) {
            addCriterion("order_items between", value1, value2, "orderItems");
            return (Criteria) this;
        }

        public Criteria andOrderItemsNotBetween(String value1, String value2) {
            addCriterion("order_items not between", value1, value2, "orderItems");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNull() {
            addCriterion("order_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNotNull() {
            addCriterion("order_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceEqualTo(BigDecimal value) {
            addCriterion("order_price =", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotEqualTo(BigDecimal value) {
            addCriterion("order_price <>", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThan(BigDecimal value) {
            addCriterion("order_price >", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_price >=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThan(BigDecimal value) {
            addCriterion("order_price <", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_price <=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIn(List<BigDecimal> values) {
            addCriterion("order_price in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotIn(List<BigDecimal> values) {
            addCriterion("order_price not in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_price between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_price not between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderVipPriceIsNull() {
            addCriterion("order_vip_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderVipPriceIsNotNull() {
            addCriterion("order_vip_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderVipPriceEqualTo(BigDecimal value) {
            addCriterion("order_vip_price =", value, "orderVipPrice");
            return (Criteria) this;
        }

        public Criteria andOrderVipPriceNotEqualTo(BigDecimal value) {
            addCriterion("order_vip_price <>", value, "orderVipPrice");
            return (Criteria) this;
        }

        public Criteria andOrderVipPriceGreaterThan(BigDecimal value) {
            addCriterion("order_vip_price >", value, "orderVipPrice");
            return (Criteria) this;
        }

        public Criteria andOrderVipPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_vip_price >=", value, "orderVipPrice");
            return (Criteria) this;
        }

        public Criteria andOrderVipPriceLessThan(BigDecimal value) {
            addCriterion("order_vip_price <", value, "orderVipPrice");
            return (Criteria) this;
        }

        public Criteria andOrderVipPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_vip_price <=", value, "orderVipPrice");
            return (Criteria) this;
        }

        public Criteria andOrderVipPriceIn(List<BigDecimal> values) {
            addCriterion("order_vip_price in", values, "orderVipPrice");
            return (Criteria) this;
        }

        public Criteria andOrderVipPriceNotIn(List<BigDecimal> values) {
            addCriterion("order_vip_price not in", values, "orderVipPrice");
            return (Criteria) this;
        }

        public Criteria andOrderVipPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_vip_price between", value1, value2, "orderVipPrice");
            return (Criteria) this;
        }

        public Criteria andOrderVipPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_vip_price not between", value1, value2, "orderVipPrice");
            return (Criteria) this;
        }

        public Criteria andOrderProductIsNull() {
            addCriterion("order_product is null");
            return (Criteria) this;
        }

        public Criteria andOrderProductIsNotNull() {
            addCriterion("order_product is not null");
            return (Criteria) this;
        }

        public Criteria andOrderProductEqualTo(String value) {
            addCriterion("order_product =", value, "orderProduct");
            return (Criteria) this;
        }

        public Criteria andOrderProductNotEqualTo(String value) {
            addCriterion("order_product <>", value, "orderProduct");
            return (Criteria) this;
        }

        public Criteria andOrderProductGreaterThan(String value) {
            addCriterion("order_product >", value, "orderProduct");
            return (Criteria) this;
        }

        public Criteria andOrderProductGreaterThanOrEqualTo(String value) {
            addCriterion("order_product >=", value, "orderProduct");
            return (Criteria) this;
        }

        public Criteria andOrderProductLessThan(String value) {
            addCriterion("order_product <", value, "orderProduct");
            return (Criteria) this;
        }

        public Criteria andOrderProductLessThanOrEqualTo(String value) {
            addCriterion("order_product <=", value, "orderProduct");
            return (Criteria) this;
        }

        public Criteria andOrderProductLike(String value) {
            addCriterion("order_product like", value, "orderProduct");
            return (Criteria) this;
        }

        public Criteria andOrderProductNotLike(String value) {
            addCriterion("order_product not like", value, "orderProduct");
            return (Criteria) this;
        }

        public Criteria andOrderProductIn(List<String> values) {
            addCriterion("order_product in", values, "orderProduct");
            return (Criteria) this;
        }

        public Criteria andOrderProductNotIn(List<String> values) {
            addCriterion("order_product not in", values, "orderProduct");
            return (Criteria) this;
        }

        public Criteria andOrderProductBetween(String value1, String value2) {
            addCriterion("order_product between", value1, value2, "orderProduct");
            return (Criteria) this;
        }

        public Criteria andOrderProductNotBetween(String value1, String value2) {
            addCriterion("order_product not between", value1, value2, "orderProduct");
            return (Criteria) this;
        }

        public Criteria andOrderProductNumIsNull() {
            addCriterion("order_product_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderProductNumIsNotNull() {
            addCriterion("order_product_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderProductNumEqualTo(Integer value) {
            addCriterion("order_product_num =", value, "orderProductNum");
            return (Criteria) this;
        }

        public Criteria andOrderProductNumNotEqualTo(Integer value) {
            addCriterion("order_product_num <>", value, "orderProductNum");
            return (Criteria) this;
        }

        public Criteria andOrderProductNumGreaterThan(Integer value) {
            addCriterion("order_product_num >", value, "orderProductNum");
            return (Criteria) this;
        }

        public Criteria andOrderProductNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_product_num >=", value, "orderProductNum");
            return (Criteria) this;
        }

        public Criteria andOrderProductNumLessThan(Integer value) {
            addCriterion("order_product_num <", value, "orderProductNum");
            return (Criteria) this;
        }

        public Criteria andOrderProductNumLessThanOrEqualTo(Integer value) {
            addCriterion("order_product_num <=", value, "orderProductNum");
            return (Criteria) this;
        }

        public Criteria andOrderProductNumIn(List<Integer> values) {
            addCriterion("order_product_num in", values, "orderProductNum");
            return (Criteria) this;
        }

        public Criteria andOrderProductNumNotIn(List<Integer> values) {
            addCriterion("order_product_num not in", values, "orderProductNum");
            return (Criteria) this;
        }

        public Criteria andOrderProductNumBetween(Integer value1, Integer value2) {
            addCriterion("order_product_num between", value1, value2, "orderProductNum");
            return (Criteria) this;
        }

        public Criteria andOrderProductNumNotBetween(Integer value1, Integer value2) {
            addCriterion("order_product_num not between", value1, value2, "orderProductNum");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andModifyByIsNull() {
            addCriterion("modify_by is null");
            return (Criteria) this;
        }

        public Criteria andModifyByIsNotNull() {
            addCriterion("modify_by is not null");
            return (Criteria) this;
        }

        public Criteria andModifyByEqualTo(String value) {
            addCriterion("modify_by =", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotEqualTo(String value) {
            addCriterion("modify_by <>", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByGreaterThan(String value) {
            addCriterion("modify_by >", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByGreaterThanOrEqualTo(String value) {
            addCriterion("modify_by >=", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByLessThan(String value) {
            addCriterion("modify_by <", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByLessThanOrEqualTo(String value) {
            addCriterion("modify_by <=", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByLike(String value) {
            addCriterion("modify_by like", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotLike(String value) {
            addCriterion("modify_by not like", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByIn(List<String> values) {
            addCriterion("modify_by in", values, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotIn(List<String> values) {
            addCriterion("modify_by not in", values, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByBetween(String value1, String value2) {
            addCriterion("modify_by between", value1, value2, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotBetween(String value1, String value2) {
            addCriterion("modify_by not between", value1, value2, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("modify_date is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("modify_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterion("modify_date =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterion("modify_date <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterion("modify_date >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_date >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterion("modify_date <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("modify_date <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterion("modify_date in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterion("modify_date not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterion("modify_date between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("modify_date not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}