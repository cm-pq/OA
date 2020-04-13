package com.ujiuye.cus.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.CustomerExample;
import com.ujiuye.cus.bean.CustomerVo;
import com.ujiuye.cus.mapper.CustomerMapper;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CustomerIml implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    public CustomerMapper getCustomerMapper() {
        return customerMapper;
    }

    public void setCustomerMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }




    @Override
    public PageInfo<Customer> selectAll(int curreyPage) {
        PageHelper.startPage(curreyPage,3);
        List<Customer> customers = customerMapper.selectAll();
         PageInfo<Customer> customerPageInfo = new PageInfo<>(customers);
        return customerPageInfo;

    }

    @Override
    public boolean add(Customer customer) {
        int i = customerMapper.insertSelective(customer);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public Customer select(Integer c) {
        Customer customer = customerMapper.selectByPrimaryKey(c);
        return customer;
    }

    @Override
    public boolean updata(Customer customer ) {
        int i = customerMapper.updateByPrimaryKeySelective(customer);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public void delect(List<Integer> id) {
        System.out.println(id);
        customerMapper.delectin(id);
        System.out.println("已执行");
    }

    @Override
    public PageInfo<Customer> search(Integer currentPage, CustomerVo customerVo) {
        PageHelper.startPage(currentPage,3);
        List<Customer> customers = customerMapper.searce(customerVo);
        System.out.println("service"+customers);
        PageInfo<Customer> customerPageInfo = new PageInfo<>(customers);
        return customerPageInfo;
    }

    @Override
    public List<Customer> selectname() {

        return customerMapper.selectByExample(null);

    }

    @Override
    public Customer selectone(Integer integer) {

        return customerMapper.selectByPrimaryKey(integer);
    }

    @Override
    public List<Customer> selectAl() {
        return customerMapper.selectByExample(null);
    }

}
