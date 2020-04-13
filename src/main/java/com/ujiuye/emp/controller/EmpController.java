package com.ujiuye.emp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ujiuye.dept.bean.Dept;
import com.ujiuye.emp.bean.EmploExtend;
import com.ujiuye.emp.bean.Employee;
import com.ujiuye.emp.bean.QuanXian;
import com.ujiuye.emp.service.EmpService;
import com.ujiuye.level.bean.Level;
import com.ujiuye.position.bean.Position;
import com.ujiuye.role.bean.Role;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("emp")
public class EmpController {
    @Autowired
  private EmpService empService;
    @Autowired
    private JedisPool jedisPool;
    @RequestMapping("selectAll")
    @ResponseBody
public List<Employee> selectOne() {
        List<Employee> selectone = empService.selectone();
        return selectone;
}
@RequestMapping("login")
public String login(String name, String pass, Model model, HttpServletResponse response, HttpServletRequest request) throws JsonProcessingException {

    Employee employee = empService.logon(name, pass);

    if (employee !=null){
        Jedis resource = jedisPool.getResource();
        String key = UUID.randomUUID().toString().replace("-","_")+"_"+employee.getEid();
/*
                对象实例化转为json字符串
*/
        ObjectMapper objectMapper = new ObjectMapper();
        String value =  objectMapper.writeValueAsString(employee);
        resource.set(key,value);
        resource.expire(key,30000);
        resource.close();

        Cookie cookie = new Cookie("user",key);
        //原先cookie路径只允许当前请求使用即项目名/emp请求,这里获取项目名使整个项目都可以获取
        cookie.setPath(request.getContextPath());
         response.addCookie(cookie);

        return "index";

    }else {

       model.addAttribute("msg","对不起,请检查用户名或密码是否输入正确");
        return "login";

    }

}
@RequestMapping("logout")
public String logout(@CookieValue("user") String user, HttpSession session,HttpServletRequest request,HttpServletResponse response){
        //注销session
   /*
   测试异常处理器
   int c = 6/0;*/
    session.invalidate();
    //注销coolie

    /*获取所有cookie*/
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie :cookies) {//遍历所有Cookie
        if (cookie.getName().equals("user")) {//找到对应的cookie

            cookie.setMaxAge(0);
            cookie.setValue(null);
            response.addCookie(cookie);
            //功能不行仅限参考
        }
    }
    //注销redis
    Jedis resource = jedisPool.getResource();
    //让其时间立即生效并删除
    resource.expire(user,0);
    resource.close();
    System.out.println("用户已注销");
    return "redirect:/login.jsp";
}
//员工展示
    @RequestMapping("user")
    public String user(Model model){
     List<EmploExtend> emploExtends =  empService.user();
        model.addAttribute("emm",emploExtends);
        for (EmploExtend e:emploExtends ) {

        }

        return "user";
    }
        @RequestMapping("getPosition")
        @ResponseBody
        public List<Position> getPosition(){ return empService.getPosition();}
        @RequestMapping("getLevel")
        @ResponseBody
        public List<Level> getLevel(){ return empService.getLevel(); }
        @RequestMapping("getDept")
        @ResponseBody
        public List<Dept> getDept(){ return empService.getDept();}
        @RequestMapping("getRole")
        @ResponseBody
        public List<Role> getRole(){return empService.getRole();}
      @RequestMapping("addEmp")
       public String addEmp(Integer roleid,Employee employee){
       empService.addEmp(roleid,employee);
        return "redirect:/emp/user";
      }

    @RequestMapping("co")
    @ResponseBody
    public QuanXian co(@CookieValue("user") String user) {

        int index = user.lastIndexOf("_");
        String value = user.substring(index + 1);
        int ek = (int) Integer.valueOf(value);
        /*int ek = 14;*/
        return empService.quanxian(ek);
    }
    //查所有人
@RequestMapping("all")
    @ResponseBody
    public List<Employee> all(){



       return empService.all();
}


}
