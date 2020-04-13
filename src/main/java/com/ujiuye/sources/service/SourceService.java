package com.ujiuye.sources.service;

import com.ujiuye.role.bean.Role;
import com.ujiuye.sources.bean.RoleSourceExtend;
import com.ujiuye.sources.bean.SourceExtend;
import com.ujiuye.sources.bean.Sources;

import java.util.List;

public interface SourceService {
    List<SourceExtend> tree();

    void addRole(String sourcesid, Role role);

    RoleSourceExtend up(Integer roleid);

    RoleSourceExtend updata();

    void updataInfo(String ids, Role role);

    void add(Sources sources);

    boolean delete(Integer id);

    Sources getOneById(Integer id);

    void update(Sources sources);
}
