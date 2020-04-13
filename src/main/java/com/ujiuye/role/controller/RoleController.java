package com.ujiuye.role.controller;

import com.ujiuye.role.bean.Role;
import com.ujiuye.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("ro")
public class RoleController {
    @Autowired
   private RoleService roleService;
    @RequestMapping("ro")
    public String ro(Model model){
       List<Role> roles = roleService.ro();
       model.addAttribute("roles",roles);
        return "role";
    }

}
