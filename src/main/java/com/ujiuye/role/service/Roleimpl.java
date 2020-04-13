package com.ujiuye.role.service;

import com.ujiuye.role.bean.Role;
import com.ujiuye.role.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class Roleimpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Override
    public List<Role> ro() {

        return roleMapper.selectByExample(null);
    }
}
