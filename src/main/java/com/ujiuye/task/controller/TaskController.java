package com.ujiuye.task.controller;

import com.ujiuye.task.bean.Task;
import com.ujiuye.task.bean.TaskExtend;
import com.ujiuye.task.service.TaskService;
import jdk.nashorn.internal.codegen.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("ta")
public class TaskController {
    @Autowired
  private TaskService taskService;
    @RequestMapping("yi")
    @ResponseBody
    public TaskExtend yi(Integer func){
       TaskExtend taskExtends = taskService.yi(func);
       return taskExtends;



    }
    @RequestMapping("add")
public String add (Task task,@CookieValue("user")String user){

        System.out.println("师德师风大富翁"+user);
        return "";
}
}
