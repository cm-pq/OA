package com.ujiuye.module.Controller;

import com.ujiuye.module.Service.ModelService;
import com.ujiuye.module.bean.ModelExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("mod")
public class ModulController {
    @Autowired
    public ModelService ModelService;
    @RequestMapping("show")
    public String show(Model model){
     List<ModelExtend> modelExtends =   ModelService.show();
    System.out.println(modelExtends);
    model.addAttribute("ddl",modelExtends);
        return "project-model";
    }



}
