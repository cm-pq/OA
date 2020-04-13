package com.ujiuye.function.controller;

import com.ujiuye.function.bean.Funcextend;
import com.ujiuye.function.service.FuncService;
import com.ujiuye.project.bean.Project;
import com.ujiuye.project.mapper.ProjectMapper;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.portable.ValueOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.reflect.generics.tree.VoidDescriptor;

import java.util.List;


@Controller
@RequestMapping("func")
public class FuncController {
    @Autowired
    private FuncService funcService;
    @RequestMapping("ht")
    @ResponseBody
   public Funcextend addyi(Integer pid){
        System.out.println(pid);
      Funcextend funcextends=  funcService.addyi(pid);

       return funcextends;
   }
   @RequestMapping("selp")
   @ResponseBody
  public List<Project> ff(){

     List<Project> project =   funcService.selp();

      return  project;
  }




}
