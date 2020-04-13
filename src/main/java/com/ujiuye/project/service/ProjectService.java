package com.ujiuye.project.service;

import com.github.pagehelper.PageInfo;
import com.ujiuye.analysis.bean.Analysis;
import com.ujiuye.project.bean.ProNeed;
import com.ujiuye.project.bean.Project;
import com.ujiuye.project.bean.ProjectSearch;

import java.util.List;

public interface ProjectService {
    PageInfo<Project> show(Integer currentPage);

    boolean insert(Project project);

    Project look(Integer pid);

    void updata(Project project);

    void del(List<Integer> pid);

    PageInfo<Project> searce(ProjectSearch projectSearch,Integer c);

    List<Project> sel(Integer mark);

    void add(Analysis analysis);

    List<ProNeed> showNeed();
}
