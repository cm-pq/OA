package com.ujiuye.cus.mapper;


import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.CustomerExample;
import com.ujiuye.cus.bean.CustomerVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    int countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    List<Customer> selectAll() ;
    void delectin(List<Integer> id);

    List<Customer> searce(CustomerVo customerVo);
}