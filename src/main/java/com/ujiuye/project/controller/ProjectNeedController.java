package com.ujiuye.project.controller;
import com.ujiuye.analysis.bean.Analysis;
import com.ujiuye.project.bean.ProNeed;
import com.ujiuye.project.bean.Project;
import com.ujiuye.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("proneed")
public class ProjectNeedController {
    int c = 0;
    @Autowired
    private ProjectService projectService;

    @RequestMapping("showInfo")
    @ResponseBody
    public List<Project> sel(Integer mark) {
        System.out.println(mark);
        List<Project> projects = projectService.sel(mark);

        return projects;

    }

    @RequestMapping("add")
    public String add(Analysis analysis, MultipartFile files) throws IOException {
        analysis.setAddtime(new Date());

        if (files != null) {
            //获取文件名称
            String filename = files.getOriginalFilename();
            // 获取文件尾缀
            int i = filename.lastIndexOf(".");
            //获取后缀
            String substring = filename.substring(i);
            c++;
            String q = "附件" + "(" + c + ")";
            filename = q + substring;
            //指定文件保存位置
            File file = new File("C:\\Users\\Administrator\\Desktop", filename);
            //向指定的位置复制上传文件
            files.transferTo(file);
            //数据库保存文件名
            analysis.setProname(file.getPath());
        }
        projectService.add(analysis);
        return "redirect:/proneed/show-need";
    }

    @RequestMapping("show-need")
    public String show(Model model) {
        List<ProNeed> proNeeds = projectService.showNeed();

        model.addAttribute("peed", proNeeds);
        return "project-need";
    }

    @RequestMapping("download")
    public String down(String filename, HttpServletResponse httpResponse) throws IOException {
        System.out.println(filename);
        //设置一个头两个流
        File file = new File(filename);
        //中文乱码处理,分两部分
        String name = new String(file.getName().getBytes("utf-8"), "iso8859-1");
        //设置响应头
        httpResponse.setHeader("Content-Disposition", "attachment;filename=" + name);
        //读取服务器的输入流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        /*将服务器文件写入到用户的本地*/
        ServletOutputStream outputStream = httpResponse.getOutputStream();
        byte[] as = new byte[1024];
        int len = -1;
        //读写输出
        while ((len = bufferedInputStream.read(as)) != -1) {
            outputStream.write(as, 0, len);

        }
        bufferedInputStream.close();
        outputStream.close();
        return "redirect:/proneed/show-need";


    }
}