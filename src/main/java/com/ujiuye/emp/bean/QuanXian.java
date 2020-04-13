package com.ujiuye.emp.bean;

import com.ujiuye.role.bean.Role;
import com.ujiuye.sources.bean.RoleSourceExtend;
import com.ujiuye.sources.bean.SourceExtend;
import java.util.List;

public class QuanXian {
    //目的:获取一个员工可以操作哪些资源
    //资源
  private RoleSourceExtend roleSourceExtend;
    //角色
    private Role role;
    //员工
    private Employee employee;

   private List<SourceExtend> sourceExtends;

    @Override
    public String toString() {
        return "QuanXian{" +
                "roleSourceExtend=" + roleSourceExtend +
                ", role=" + role +
                ", employee=" + employee +
                ", sourceExtends=" + sourceExtends +
                '}';
    }

    public RoleSourceExtend getRoleSourceExtend() {
        return roleSourceExtend;
    }

    public void setRoleSourceExtend(RoleSourceExtend roleSourceExtend) {
        this.roleSourceExtend = roleSourceExtend;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<SourceExtend> getSourceExtends() {
        return sourceExtends;
    }

    public void setSourceExtends(List<SourceExtend> sourceExtends) {
        this.sourceExtends = sourceExtends;
    }
}
