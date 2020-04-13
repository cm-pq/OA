package com.ujiuye.evaluate.controller;

import com.ujiuye.evaluate.bean.Evaluate;
import com.ujiuye.evaluate.service.EvaService;
import org.apache.poi.util.SystemOutLogger;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("eva")
public class Evacontroller {
    @Autowired
   private EvaService evaService;
    @RequestMapping("add")
    public String add(Evaluate e, @CookieValue("user")String user){
        int index = user.lastIndexOf("_");
        String value = user.substring(index + 1);
        int ek = (int) Integer.valueOf(value);
        e.setEmpFk4(ek);
         e.setEvatime(new Date());

        evaService.add(e);
        return "redirect:/fo/look?id="+e.getForumFk();
    }



}
