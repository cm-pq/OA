package com.ujiuye.task.bean;

import com.ujiuye.emp.bean.Employee;
import com.ujiuye.function.bean.Function;

import java.util.List;

public class TaskExtend {
    private Employee employee;
    private List<Function> functions;

    @Override
    public String toString() {
        return "TaskExtend{" +
                "employee=" + employee +
                ", functions=" + functions +
                '}';
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    public Employee getEmployee() {

        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
