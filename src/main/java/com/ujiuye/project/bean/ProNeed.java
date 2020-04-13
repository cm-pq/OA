package com.ujiuye.project.bean;

import com.ujiuye.analysis.bean.Analysis;

public class ProNeed extends Analysis {
    private Project project;
    @Override
    public String toString() {
        return "ProNeed{" +
                "project=" + project +
                '}';
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }



}
