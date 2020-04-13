package com.ujiuye.baoxiao.controller;

import com.ujiuye.baoxiao.bean.Baoxiao;
import com.ujiuye.baoxiao.bean.BaoxiaoExtend;
import com.ujiuye.baoxiao.bean.Baoxiaoreply;
import com.ujiuye.baoxiao.bean.Expendituretype;
import com.ujiuye.baoxiao.service.BaoxiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("bao")
public class BaoxiaoController {
    @Autowired
    private BaoxiaoService baoxiaoService;
    @RequestMapping("show")
    public String show(Model model,@CookieValue("user") String user){
        int index = user.lastIndexOf("_");
        String value = user.substring(index+1);
        Integer ek = Integer.valueOf(value);
        String uuid =UUID.randomUUID().toString();
    List<Baoxiao> baoxiaos = baoxiaoService.show(ek);
   model.addAttribute("baoxiao",baoxiaos);
   return "mybaoxiao-base";
    }
    @RequestMapping("showType")
    @ResponseBody
    public List<Expendituretype> showType(){
       List<Expendituretype> expendituretypes = baoxiaoService.showType();
        return expendituretypes;
    }
    @RequestMapping("save")
    public String save(Baoxiao baoxiao, @CookieValue("user") String user){
        int index = user.lastIndexOf("_");
        String value = user.substring(index+1);
        Integer ek = Integer.valueOf(value);
        String uuid =UUID.randomUUID().toString();
        baoxiao.setBxid(uuid);
        baoxiao.setBxstatus(0);
        baoxiao.setEmpFk(ek);
        baoxiaoService.save(baoxiao);
  return "redirect:/bao/show";
    }
    @RequestMapping("xiao")
    public String xiao(Model model){
      List<BaoxiaoExtend> baoxiaoExtends =  baoxiaoService.xiao();
model.addAttribute("xiao",baoxiaoExtends);

        return "baoxiao-task";
    }
    @RequestMapping("shen")
    public String shen(String ss,Model model){

      BaoxiaoExtend baoxiaoExtend =  baoxiaoService.shen(ss);
   model.addAttribute("shen",baoxiaoExtend);
        return "baoxiao-task-edit";
    }
    @RequestMapping("shenpi")
    public String shenpi(Integer bxstatus,String bxid,String result){
        baoxiaoService.shenpi(bxstatus,bxid,result);
        System.out.println("来了");
    return "redirect:/bao/xiao";
    }
}
