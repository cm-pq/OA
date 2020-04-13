package com.ujiuye.sources.bean;

import com.ujiuye.role.bean.Role;

import java.util.List;

public class RoleSourceExtend  {

   private  List<RoleSources> roleSources;
   private  Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<RoleSources> getRoleSources() {
        return roleSources;
    }

    public void setRoleSources(List<RoleSources> roleSources) {
        this.roleSources = roleSources;
    }



}
