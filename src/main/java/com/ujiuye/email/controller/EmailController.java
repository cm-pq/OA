package com.ujiuye.email.controller;

import com.ujiuye.email.bean.Email;
import com.ujiuye.email.service.EmailService;
import com.ujiuye.emp.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping("em")
public class EmailController {
    @Autowired
    private EmailService emailService ;
    @RequestMapping("em")
    @ResponseBody
    public List<Employee> em(){
     return emailService.em();
    }
    @RequestMapping("email")
    public String save(Email email, MultipartFile files/*, String newemail用于获取页面传来的邮箱,这里采用string自创*//*, @CookieValue("user")String user 底下有解释*/) throws IOException, MessagingException {
        System.out.println(email+"...................."+files.getOriginalFilename());
        File file = null;
        if(files != null){
            /////////////////////////////////////////上传操作////////////////////////////////////////////////////
            //获取附件的名字
            String originalFilename = files.getOriginalFilename();
            file = new File("C:\\Users\\Administrator\\Desktop",originalFilename);
            files.transferTo(file);
        }
          //设置发送时间
        email.setSendtime(new Date());
        //设置eid要启动redis麻烦
       /* int index = user.lastIndexOf("_");
        String value = user.substring(index+1);
        int eid = Integer.parseInt(value);*/
       int eid = 1;
        email.setEmpFk2(eid);




        String sendP="1420337182@qq.com";//发送方
        String code ="tzzlrojcxvnwhfcc";//授权码

        String recvP="2796277160@qq.com";//接收方
        String server="smtp.qq.com";//服务器

        Properties properties=new Properties();
        //协议
        properties.setProperty("mail.transport.protocol", "smtp");
        //服务器地址
        properties.setProperty("mail.smtp.host", server);
        //是否验证
        properties.setProperty("mail.smtp.auth", "true");
        /////////向上参数配置完成
        //创建验证器--在实现连接的时候，用验证器来实现登录验证
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                // 密码验证
                return new PasswordAuthentication(sendP, code);// 邮箱的授权码
            }

        };
        //建立连接(连接参数和验证)
        Session session = Session.getInstance(properties, auth);
        session.setDebug(true);
        //封装邮件
        MimeMessage message = createMimeMessage(email,file,session,sendP,recvP);

        //传输对象
        Transport transport = session.getTransport();
        transport.connect(sendP, code);
        //发送邮件
        transport.sendMessage(message, message.getAllRecipients());//相当于在邮箱中点击发送邮件的按钮

        transport.close();





        return "email";

    }
    private MimeMessage createMimeMessage(Email email, File file, Session session, String sendP, String recvP) throws UnsupportedEncodingException, MessagingException {
        //封装一封邮件
        //邮件对象
        MimeMessage message = new MimeMessage(session);
        //接收方--可以设置接收方的昵称
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recvP, "老展", "UTF-8"));
        //发送方---可以设置昵称
        message.setFrom(new InternetAddress(sendP, "鸳鸯牌洗发水", "UTF-8"));
        //标题
        message.setSubject(email.getTitle(), "UTF-8");
        //内容：文本+附件(附件可能没有)
        //先设置文本，后设置附件
        // 创建多重消息(既有文本又有对象)
        Multipart multipart = new MimeMultipart();
        //保存文本和附件的对象BodyPart
        BodyPart messageBodyPart = new MimeBodyPart();
        if(email.getEmailcontent() != null && email.getEmailcontent().length() > 0) {
            messageBodyPart.setText(email.getEmailcontent());
            //在一个网站中注册之后，网站发送到邮箱中一个激活链接
//        messageBodyPart.setContent("<a target='_BLANK' href='http://www.baidu.com'>先生/女士您好，请点击此链接激活账号</a>","text/html;charset=utf-8");
        }else {
            messageBodyPart.setText("");
        }
        //把内容中的文本部分，添加到多重消息对象中
        multipart.addBodyPart(messageBodyPart);

        if(file != null) {
            //附件
            messageBodyPart = new MimeBodyPart();
            //读取附件
            DataSource source = new FileDataSource(file);
            //把附件保存到bodyPart对象
            messageBodyPart.setDataHandler(new DataHandler(source));
            //解决发送附件的中文乱码
            messageBodyPart.setFileName(MimeUtility.encodeText(file.getName()));

            //把bodyPart放入多重信息对象
            multipart.addBodyPart(messageBodyPart);
        }

        //邮件对象封装内容部分
        message.setContent(multipart);

        Date date = new Date(System.currentTimeMillis()+5000);
        message.setSentDate(date);

        message.saveChanges();

        return message;
    }

}
