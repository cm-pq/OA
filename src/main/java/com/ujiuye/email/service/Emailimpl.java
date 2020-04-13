package com.ujiuye.email.service;

import com.ujiuye.emp.bean.Employee;
import com.ujiuye.emp.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class Emailimpl implements EmailService {
    @Resource
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> em() {
        return employeeMapper.selectByExample(null);
    }
}
