package com.ujiuye.attachment.bean;

import com.ujiuye.project.bean.Project;

public class AttExtend extends Attachment{
    private Project project;

    @Override
    public String toString() {
        return "AttExtend{" +
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
