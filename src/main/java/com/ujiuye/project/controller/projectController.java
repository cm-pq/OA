package com.ujiuye.project.controller;

import com.github.pagehelper.PageInfo;
import com.ujiuye.project.bean.Project;
import com.ujiuye.project.bean.ProjectSearch;
import com.ujiuye.project.service.ProjectService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileOutputStream;
import java.util.List;

@Controller
@RequestMapping("pro")
public class projectController {
    @Autowired
    private ProjectService projectService;
    int c =0;
    //展示信息
    @RequestMapping("project-show")
    @ResponseBody
    public PageInfo<Project> show(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "1")  Integer func ,ProjectSearch projectSearch){

      PageInfo<Project> projectEXES = projectService.show(currentPage);
      //FUNC必须1设定初始值否则,这里调用会空指针,或判断其为null;

       if (func==999){
           c++;
            System.out.println("值为"+projectEXES);
            List<Project> list = projectEXES.getList();
//导出excel步骤
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
            HSSFSheet hssfSheet = hssfWorkbook.createSheet("项目添加表");
//第一行表头
            HSSFRow row = hssfSheet.createRow(0);
            //创建单元格
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("编号");
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue("项目名称");
            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue("客户方负责人");
            HSSFCell cell3 = row.createCell(3);
            cell3.setCellValue("计划完成时间");
            HSSFCell cell4 = row.createCell(4);
            cell4.setCellValue("计划开始时间");
            for (int i = 0; i < list.size(); i++) {

                Project project = list.get(i);
                //创建第二行
                HSSFRow row1 = hssfSheet.createRow(i + 1);
                HSSFCell cell7 = row1.createCell(0);
                cell7.setCellValue(project.getPid() + "");
                HSSFCell cell8 = row1.createCell(1);
                cell8.setCellValue(project.getCustomer().getComname());
                HSSFCell cell9 = row1.createCell(2);
                cell9.setCellValue(project.getCustomer().getCompanyperson());
                HSSFCell cell0 = row1.createCell(3);
                cell0.setCellValue(project.getEndtime());
                HSSFCell cell22 = row1.createCell(4);
                cell22.setCellValue(project.getStarttime());


            }
            try {
                // js  prompt("输入路径")
                FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\项目信息表" +
                        c+".xls");
                hssfWorkbook.write(fos);
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return projectEXES;
        }
        return projectEXES;
    }

@RequestMapping("insert")
    public String insert(Project project){
       boolean c = projectService.insert(project);
          return "redirect:/project-base.jsp";

}
@RequestMapping("edit")
public String edit(Integer func, Model model,Integer pid){

    Project project =  projectService.look(pid);
      model.addAttribute("project",project);
   if (func<0){
       return "project-base-look";
   }
       return "project-base-edit";
}
@RequestMapping("updata")
public String updata(Project project){
    System.out.println(project);
        projectService.updata(project);
        return "redirect:/project-base.jsp";
}
//删除
    @RequestMapping("del")
    public String del(@RequestParam List<Integer> pid){
        projectService.del(pid);
        return "redirect:/project-base.jsp";
    }

        @RequestMapping("search")
        @ResponseBody
        public PageInfo<Project> search(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "1")  Integer func ,ProjectSearch projectSearch){
            System.out.println("二"+projectSearch);
            System.out.println(currentPage);

            PageInfo<Project> projectEXES = projectService.searce(projectSearch,currentPage);
            //FUNC必须1设定初始值否则,这里调用会空指针,或判断其为null;
            System.out.println(projectEXES.getList());
            if (func==999){
                c++;
                System.out.println("值为"+projectEXES);
                List<Project> list = projectEXES.getList();
//导出excel步骤
                HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
                HSSFSheet hssfSheet = hssfWorkbook.createSheet("项目添加表");
//第一行表头
                HSSFRow row = hssfSheet.createRow(0);
                //创建单元格
                HSSFCell cell = row.createCell(0);
                cell.setCellValue("编号");
                HSSFCell cell1 = row.createCell(1);
                cell1.setCellValue("项目名称");
                HSSFCell cell2 = row.createCell(2);
                cell2.setCellValue("客户方负责人");
                HSSFCell cell3 = row.createCell(3);
                cell3.setCellValue("计划完成时间");
                HSSFCell cell4 = row.createCell(4);
                cell4.setCellValue("计划开始时间");
                for (int i = 0; i < list.size(); i++) {

                    Project project = list.get(i);
                    //创建第二行
                    HSSFRow row1 = hssfSheet.createRow(i + 1);
                    HSSFCell cell7 = row1.createCell(0);
                    cell7.setCellValue(project.getPid() + "");
                    HSSFCell cell8 = row1.createCell(1);
                    cell8.setCellValue(project.getCustomer().getComname());
                    HSSFCell cell9 = row1.createCell(2);
                    cell9.setCellValue(project.getCustomer().getCompanyperson());
                    HSSFCell cell0 = row1.createCell(3);
                    cell0.setCellValue(project.getEndtime());
                    HSSFCell cell22 = row1.createCell(4);
                    cell22.setCellValue(project.getStarttime());


                }
                try {
                    // js  prompt("输入路径")
                    FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\项目信息表" +
                            c+".xls");
                    hssfWorkbook.write(fos);
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return projectEXES;
            }
            return projectEXES;
        }

}
