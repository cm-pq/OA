package com.ujiuye.sources.controller;

import com.ujiuye.role.bean.Role;
import com.ujiuye.sources.bean.RoleSourceExtend;
import com.ujiuye.sources.bean.SourceExtend;
import com.ujiuye.sources.bean.Sources;
import com.ujiuye.sources.service.SourceService;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.poi.util.DelayableLittleEndianOutput;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("so")
public class SorController {
    @Autowired
    private SourceService sourceService;
    @RequestMapping("tree")
    @ResponseBody
    public List<SourceExtend> tree(){
        List<SourceExtend> tree = sourceService.tree();
        return tree;

    }
    @RequestMapping("addRole")
    public String addRole(String sourcesid, Role role){
        System.out.println("接受到值为"+sourcesid);
    sourceService.addRole(sourcesid,role);

        return  "redirect:/ro/ro";
    }
    @RequestMapping("up")
    @ResponseBody
    public RoleSourceExtend up(Integer roleid){
        return  sourceService.up(roleid);
    }
    @RequestMapping("updateInfo")
    public String updateInfo(String ids, Role role){
      sourceService.updataInfo(ids,role);


        return  "redirect:/ro/ro";
    }
    /*权限源添加*/
    @RequestMapping("add")
    public String add(Sources sources){
        System.out.println(sources);
        sourceService.add(sources);
      return "redirect:../pm.jsp";
    }
@RequestMapping("delete")
@ResponseBody
    public boolean delete(Integer id){
       boolean cc = sourceService.delete(id);
        return cc;
}
@RequestMapping("getOneById")
    public String getOneById(Integer id, Model model){
    Sources sources = sourceService.getOneById(id);
     model.addAttribute("onesource",sources);
    return "pm-edit";
}
@RequestMapping("update")
    public String updata(Sources sources){
        sourceService.update(sources);

         return "redirect:../pm.jsp";
}
}
