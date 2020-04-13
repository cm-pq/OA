package com.ujiuye.baoxiao.bean;

import com.ujiuye.emp.bean.Employee;

import java.util.List;

public class BaoxiaoExtend  extends Baoxiao{
    private Employee employee;
    private Expendituretype expendituretype;
    private List<Baoxiaoreply> baoxiaoreplies;

    @Override
    public String toString() {
        return "BaoxiaoExtend{" +
                "employee=" + employee +
                ", expendituretype=" + expendituretype +
                ", baoxiaoreplies=" + baoxiaoreplies +
                '}';
    }

    public List<Baoxiaoreply> getBaoxiaoreplies() {
        return baoxiaoreplies;
    }

    public void setBaoxiaoreplies(List<Baoxiaoreply> baoxiaoreplies) {
        this.baoxiaoreplies = baoxiaoreplies;
    }

    public Expendituretype getExpendituretype() {

        return expendituretype;
    }

    public void setExpendituretype(Expendituretype expendituretype) {
        this.expendituretype = expendituretype;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
