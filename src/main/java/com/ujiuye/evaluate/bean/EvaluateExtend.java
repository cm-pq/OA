package com.ujiuye.evaluate.bean;

import com.ujiuye.emp.bean.Employee;

import java.util.List;

public class EvaluateExtend extends Evaluate{
    private Employee employee;
    private List<EvaluateExtend> chouduri;

    @Override
    public String toString() {
        return "EvaluateExtend{" +
                "employee=" + employee +
                ", chouduri=" + chouduri +
                '}';
    }

    public List<EvaluateExtend> getChouduri() {
        return chouduri;
    }

    public void setChouduri(List<EvaluateExtend> chouduri) {
        this.chouduri = chouduri;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
