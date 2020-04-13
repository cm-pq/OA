package com.ujiuye.datacollect.controller;

import com.ujiuye.datacollect.bean.DataExtend;
import com.ujiuye.datacollect.bean.Datacollect;
import com.ujiuye.datacollect.service.DataService;
import org.apache.poi.util.DelayableLittleEndianOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("da")
public class DataController {
    @Autowired
    private DataService dataService;
    @RequestMapping("caishow")
    public String caishow(Model model){
      List<Datacollect> datacollects = dataService.caishow();
        model.addAttribute("data",datacollects);
        return "duibiao-base";
    }
    @RequestMapping("show")
    @ResponseBody
    public List<Datacollect> caishow(){


        return dataService.caishow();
    }
    @RequestMapping("selectone")
    @ResponseBody
    public DataExtend caishow(Integer cname){


        return dataService.selectone(cname);
    }
    //柱状图
    @RequestMapping("zhu")
    @ResponseBody
    public List<Datacollect> zhu(){

     return   dataService.zhu();

    }





}
