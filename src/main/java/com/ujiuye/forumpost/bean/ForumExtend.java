package com.ujiuye.forumpost.bean;

import com.ujiuye.emp.bean.Employee;
import com.ujiuye.evaluate.bean.EvaluateExtend;

import java.util.List;

public class ForumExtend {
    private Forumpost forumpost;

    public List<EvaluateExtend> getEvaluateEXtend() {
        return evaluateEXtend;
    }

    public void setEvaluateEXtend(List<EvaluateExtend> evaluateEXtend) {
        this.evaluateEXtend = evaluateEXtend;
    }

    private List<EvaluateExtend> evaluateEXtend;
    private Employee employee;

    @Override
    public String toString() {
        return "ForumExtend{" +
                "forumpost=" + forumpost +
                ", evaluateEXtend=" + evaluateEXtend +
                ", employee=" + employee +
                '}';
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public Forumpost getForumpost() {
        return forumpost;
    }

    public void setForumpost(Forumpost forumpost) {
        this.forumpost = forumpost;
    }
}
