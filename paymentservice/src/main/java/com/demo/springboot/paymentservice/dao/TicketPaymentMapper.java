package com.demo.springboot.paymentservice.dao;

import com.demo.springboot.paymentservice.entity.TicketPayment;
import com.demo.springboot.paymentservice.entity.TicketPaymentExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TicketPaymentMapper {
    long countByExample(TicketPaymentExample example);

    int deleteByExample(TicketPaymentExample example);

    int deleteByPrimaryKey(String paymentId);

    int insert(TicketPayment record);

    int insertSelective(TicketPayment record);

    List<TicketPayment> selectByExample(TicketPaymentExample example);

    TicketPayment selectByPrimaryKey(String paymentId);

    int updateByExampleSelective(@Param("record") TicketPayment record, @Param("example") TicketPaymentExample example);

    int updateByExample(@Param("record") TicketPayment record, @Param("example") TicketPaymentExample example);

    int updateByPrimaryKeySelective(TicketPayment record);

    int updateByPrimaryKey(TicketPayment record);
}