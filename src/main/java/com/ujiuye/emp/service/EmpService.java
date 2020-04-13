package com.ujiuye.emp.service;

import com.ujiuye.dept.bean.Dept;
import com.ujiuye.emp.bean.EmploExtend;
import com.ujiuye.emp.bean.Employee;
import com.ujiuye.emp.bean.QuanXian;
import com.ujiuye.level.bean.Level;
import com.ujiuye.position.bean.Position;
import com.ujiuye.role.bean.Role;

import java.util.List;

public interface EmpService {
    List<Employee> selectone( );

    Employee logon(String username, String pass);

    List<EmploExtend> user();

    List<Position> getPosition();

    List<Level> getLevel();

    List<Dept> getDept();

    List<Role> getRole();

    void addEmp(Integer roleid, Employee employee);

    QuanXian quanxian(Integer eid);

    List<Employee> all();
}
