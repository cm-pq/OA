package com.ujiuye.cus.service;

import com.github.pagehelper.PageInfo;
import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.CustomerVo;

import java.util.List;

public interface CustomerService {
    PageInfo<Customer> selectAll(int curreyPage);

    boolean add(Customer customer);

    Customer select(Integer c);

    boolean updata(Customer customer);

    void delect(List<Integer> id);


    PageInfo<Customer> search(Integer currentPage, CustomerVo customerVo);

    List<Customer> selectname();

    Customer selectone(Integer integer);

    List<Customer> selectAl();
}
