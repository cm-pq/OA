package com.ujiuye.forumpost.controller;


import com.ujiuye.forumpost.bean.ForumExtend;
import com.ujiuye.forumpost.bean.Forumpost;
import com.ujiuye.forumpost.service.FourService;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
    @RequestMapping("fo")
    public class FourmController {
        @Autowired
       private FourService fourService ;
        @RequestMapping("show")
    public String show(Model model){
List<Forumpost> forumposts = fourService.show();
    model.addAttribute("fors",forumposts);
        return "forum";
    }
    @RequestMapping("add")
    public String add(Forumpost forumpost, @CookieValue("user")String user){
        int index = user.lastIndexOf("_");
        String value = user.substring(index + 1);
        int ek = (int) Integer.valueOf(value);
        forumpost.setEmpFk3(ek);
    fourService.add(forumpost);
        return "redirect:/fo/show";
    }
    @RequestMapping("look")
    public String look(Integer id,Model model){

          ForumExtend forumExtend = fourService.look(id);

          model.addAttribute("add",forumExtend);

      return "forum-reply";
    }

}
