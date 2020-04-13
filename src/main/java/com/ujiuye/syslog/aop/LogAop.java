package com.ujiuye.syslog.aop;

import com.ujiuye.syslog.bean.Syslog;
import com.ujiuye.syslog.service.SyslogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

//标识增强方法
@Aspect
public class LogAop {
    @Autowired
    private SyslogService syslogService;
    @Autowired
    private HttpServletRequest request;
@Before("execution(* com.ujiuye.*.controller.*.*(..))")
public void  doBefore(JoinPoint joinPoint){
    //joinpoint用于获取当前请求是有那个controller的哪个方法处理的
    Class aClass = joinPoint.getTarget().getClass();
    System.out.println(aClass);
    //获取方法
    String name = joinPoint.getSignature().getName();
    System.out.println(name);


}
@After("execution(* com.ujiuye.*.controller.*.*(..))")
public void  doAfter(){

    Syslog syslog = new Syslog();
    syslog.setSystime(new Date());
    //用户名，保存到redis了从redis中获取出来；保存到session了从session获取出来；保存到什么地方就从什么地方拿出来
    String username = "xxxxx";
    syslog.setSysusername(username);
    //获取地址
    String url = request.getRequestURI();
    //获取ip地址
    String ip = request.getRemoteAddr();
    System.out.println(ip);
    syslog.setSysurl(url);
    syslogService.save(syslog);


}






}
