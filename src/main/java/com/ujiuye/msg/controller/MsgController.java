package com.ujiuye.msg.controller;

import com.ujiuye.msg.bean.Msg;
import com.ujiuye.msg.bean.Msgds;
import com.ujiuye.msg.service.MsgService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("msg")
public class MsgController {
    @Autowired
    private MsgService msgService;
    @RequestMapping("show")
    public String show(Model model){
       List<Msg> msgs = msgService.show();

        model.addAttribute("msg",msgs);
        return "message-give";
    }
    @RequestMapping("saveMsg")
    public String  saveMsg(Msg msg , @CookieValue("user") String user) throws SchedulerException {
        int index = user.lastIndexOf("_");
        String value = user.substring(index+1);
        Integer ek = Integer.valueOf(value);
        msg.setSendp(ek);
        /*msgService.saveMsg(msg);*/
        //作业调度
        //容器
        Scheduler defaultScheduler = new StdSchedulerFactory().getDefaultScheduler();



        //调度者,调任务,实现功能(msgds类是要执行的功能,数据是底下送进去的数据， build.getJobDataMap().put("msg",msg);这个类要获取数据需要实现接口)
        JobDetail build = JobBuilder.newJob(Msgds.class)
                //给调度者命名和分组
                .withIdentity("ss", "p1")
                .build();
        //设置触发时间，一会这里有延迟页面隔一会才会显示
        /*Date date = new Date(System.currentTimeMillis()+1000);*/
        //设置触发器
        Trigger  triggerTriggerBuilder = TriggerBuilder.newTrigger()
                //给触发器分组和命名
                .withIdentity("mm","p1")
                //一次触发不会重复触发
                .withSchedule(SimpleScheduleBuilder.simpleSchedule())
                //设置触发时间
                .startAt(msg.getMsgtime())
                .build();
        //设置把消息数据msg对象从当前类，送到MsgJob类中
        build.getJobDataMap().put("msg",msg);
        //触发器和作业调度的关联
       defaultScheduler.scheduleJob(build, triggerTriggerBuilder);

        //启动作业调度，后台线程
        if(!defaultScheduler.isShutdown()){
            defaultScheduler.start();
        }


        return "redirect:/msg/show";
    }

}
