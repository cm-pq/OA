package com.ujiuye.ppl.controller;

import com.ujiuye.ppl.bean.Ppl;
import com.ujiuye.ppl.service.PplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("ppl")
public class Pplcontroller {
    @Autowired
   private PplService pplService;

    @RequestMapping("add")
    public String add(Ppl ppl){


        pplService.add(ppl);
      return "ppl";
    }
    @RequestMapping("ll")
public String show(Model model){


List<Ppl> po = pplService.show();
 model.addAttribute("pp",po);
    return "ppl";
    }
   /*
    responseentity<>用来作为返回值用于异步,因为是泛型,所以他可以携带任何类型到异步页面,并可设置响应头信息



    @RequestMapping("delete")
    @ResponseBody
    public ResponseEntity<Boolean> delete (int [] id){
        System.out.println("来了");
for (int i = 0; i<id.length;i++){

    System.out.println(id[i]);
}
         //没调用service没有返回对象,这里创建了一个对象
        boolean c = new  Boolean(false);
        //将返回值(响应体)返回出去
       return ResponseEntity.ok(c);
    }*/
   @RequestMapping("delete")
   @ResponseBody()//如果正常价这个注解,他会将字符串根据html结构响应出去
   public String delete (int [] id){
       System.out.println("来了");
       for (int i = 0; i<id.length;i++){

           System.out.println(id[i]);
       }
   pplService.delete(id);
       return "ppl";
   }
}
