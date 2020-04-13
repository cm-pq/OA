package com.ujiuye.attachment.controller;

import com.ujiuye.attachment.bean.AttExtend;
import com.ujiuye.attachment.bean.Attachment;
import com.ujiuye.attachment.service.AttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Controller
@RequestMapping("att")
public class AttController {
    @Autowired
     private AttService attService;
    @RequestMapping("show")
    public String show(Model model){
   List<AttExtend>  attExtends = attService.show();
 model.addAttribute("att",attExtends);

return "project-file";
    }
@RequestMapping("add")
public String add(Attachment attachment, MultipartFile[] files) throws IOException {
    System.out.println(attachment+">>>>>>>>>>>>>>>"+files);

        if (files != null&& files.length>0){
            String path = "";

            for (MultipartFile f:files ) {
                //获取每一个名字
                String originalFilename = f.getOriginalFilename();
                File file = new File("C:\\Users\\Administrator\\Desktop",originalFilename);
                //上传文件
                f.transferTo(file);
               //将路径加,分隔开
                String p = file.getPath()+",";

            path += p;
            }
           attachment.setPath(path);
            attService.add(attachment);


        }
          return "redirect:/att/show";
}
@RequestMapping("download")
public String download(String path, HttpServletResponse httpServletResponse) throws IOException {
    String[] split = path.split(",");
    //创建一个文件数组,有很多文件
    File[] files = new File[split.length];
    //遍历spilt数组,将每一个path赋值给file
    for (int i = 0;i<split.length;i++){
        //上面的数组必须要有,否则底下无法file[i],相当于file c = new file(path)
        files[i]=new File(split[i]);
    }
    //////////////////////////////////////////////////////////////总共有三个文件对象///////////////////////////////////////////////////////
    /*开始实现压缩下载先压缩后下载*/
    //设置压缩文件名
    String zname = System.currentTimeMillis()+".zip";
    String zpath = "C:\\Users\\Administrator\\Desktop\\com";
//创建文件对象
    /////////////////////////////////////////////////////////////创建新的文件对象,zip文件对象////////////////////////////////////////////
    File file2 = new File(zpath,zname);
    //创建压缩文件输出流
    ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
    //都被压缩文件
    InputStream is = null;
    /*遍历那个文件数组*/
    /////////////////////////////////////////////////////将数组里的遍历给zip对象赋值/////////////////////////////////////////////////
    for (File f:files) {
        is = new FileInputStream(f);
        //向压缩文件中添加一个被压缩的文件的名称
        zipOutputStream.putNextEntry(new ZipEntry(f.getName()));
//读和写
        int temp = 0;
        while ((temp = is.read()) != -1) {
            zipOutputStream.write(temp);

        }

        is.close();


    }
    zipOutputStream.close();
    //处理下载时名称中文乱码
    String name = file2.getName();
    //先解码，再编码
    name = new String(name.getBytes("utf-8"),"iso8859-1");
    //一个头--响应头，作用是设置下载时的文件名称的
    httpServletResponse.setHeader("Content-Disposition","attachment;filename="+name);
    //读服务器端本地文件的读入流
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file2));
    //把服务器端文件写出到用户端的写出流
    OutputStream os = httpServletResponse.getOutputStream();
    byte[]bs = new byte[1024];
    int len = -1;
    while ((len = bis.read(bs))!=-1){
        os.write(bs,0,len);
    }
    os.close();
    bis.close();
    return "redirect:/att/show";
}


}
