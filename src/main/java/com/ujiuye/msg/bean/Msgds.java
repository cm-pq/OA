package com.ujiuye.msg.bean;

import com.mysql.jdbc.Driver;
import com.ujiuye.msg.service.MsgService;
import com.ujiuye.msg.service.Msgimpl;
import org.quartz.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Msgds implements Job {
   /*
   因为是系统方法接口,所以无法注入
   @Autowired
   private MsgService msgService;*/
    //要执行的功能
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
       //在controller中将数据放到map集合中，这里通过key值来取出
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        Msg msg = (Msg)jobDataMap.get("msg");
        /*MsgService msgService = new Msgimpl();
        msgService.saveMsg(msg);*/
 //上面这种方法也不行,只能用原生态;
        Connection conn = null;
        PreparedStatement pstat = null;
        try {
            //原生态的jdbc方案实现保存
            //驱动注册
            DriverManager.registerDriver(new Driver());
            //建立连接
            conn = DriverManager.getConnection("jdbc:mysql:///crmpro?characterEncoding=utf8", "root", "root");
            //设置SQL
            String sql = "insert into msg(sendp,recvp,msgcontent,msgtime) values(?,?,?,?)";
            //定义容器
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, msg.getSendp());
            pstat.setInt(2, msg.getRecvp());
            pstat.setString(3, msg.getMsgcontent());
            pstat.setDate(4, new Date(System.currentTimeMillis()));
            //发送SQL进行执行
            pstat.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                //释放资源等
                conn.close();
                pstat.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
