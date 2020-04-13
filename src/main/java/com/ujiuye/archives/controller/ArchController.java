package com.ujiuye.archives.controller;

import com.ujiuye.archives.bean.Archives;
import com.ujiuye.archives.service.archService;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("arc")
public class ArchController {
    @Autowired
    private com.ujiuye.archives.service.archService archService;
    @RequestMapping("add")
    public String add( MultipartFile files ) throws IOException {
        if (files != null){
            String originalFilename = files.getOriginalFilename();
            System.out.println(originalFilename);
            //要将文件上传到什么地方
            File file = new File("C:\\Users\\Administrator\\Desktop\\com",originalFilename);
            //上传文件
            files.transferTo(file);
            List<Archives> archives = new ArrayList<>();
            ///////////////////////////////实现excel导入功能////////////////////////////////////////////////////////////
            //读取excel表格文件
            InputStream is = new FileInputStream(file);
            //创建一个excel文件对像
            XSSFWorkbook XSSFWorkbook = new XSSFWorkbook(is);
            //从对应的excel表格中读取sheet表格,第一个sheet表格对象
            XSSFSheet sheetAt = XSSFWorkbook.getSheetAt(0);
            //再从表格中读取行,不需要第一行
            for (int i = 1;i<=sheetAt.getLastRowNum();i++){
                //再从每一行读每个单元格中的值
                XSSFRow row = sheetAt.getRow(i);
                //直到读取完
                if (row == null){
                    continue;
                }
                //创造一个对象,完成对对象属性的赋值,一会添加给list
                Archives archive = new Archives();
                //一行一对象,一格一个属性
                 XSSFCell cell = row.getCell(0);
                if (cell == null){
                    continue;
                }
                archive.setDnum(cell.getStringCellValue());
                 XSSFCell cell1 = row.getCell(1);
                if (cell1 == null) {
                    continue;
                }
                String value = ""+cell1.getNumericCellValue();
                archive.setLandline(value);

                XSSFCell cell2 = row.getCell(2);
                if (cell2 == null) {
                    continue;
                }
                archive.setSchool(cell2.getStringCellValue());

                 XSSFCell cell3 = row.getCell(3);
                if (cell3 == null) {
                    continue;
                }
                archive.setZhuanye(cell3.getStringCellValue());

                 XSSFCell cell4 = row.getCell(4);
                if (cell4 == null) {
                    continue;
                }
                archive.setSosperson(cell4.getStringCellValue());

                 XSSFCell cell5 = row.getCell(5);
                if (cell5 == null) {
                    continue;
                }
                archive.setBiyedate(cell5.getDateCellValue());


                 XSSFCell cell6 = row.getCell(6);
                if (cell6 == null) {
                    continue;
                }
                archive.setZzmm(cell6.getStringCellValue());

                 XSSFCell cell7 = row.getCell(7);
                if (cell7 == null) {
                    continue;
                }
                archive.setMinzu(cell7.getStringCellValue());

                 XSSFCell cell8 = row.getCell(8);
                if (cell8 == null) {
                    continue;
                }
                archive.setXueli(cell8.getStringCellValue());

                 XSSFCell cell9 = row.getCell(9);
                if (cell9 == null) {
                    continue;
                }
                archive.setEmail(cell9.getStringCellValue());

                 XSSFCell cell10 = row.getCell(10);
                if (cell10 == null) {
                    continue;
                }
                double cellValue1 = cell10.getNumericCellValue();
                int value1 = (int)cellValue1;
                archive.setEmpFk(value1);

                 XSSFCell cell11 = row.getCell(11);
                if (cell11 == null) {
                    continue;
                }
                archive.setRemark(cell11.getStringCellValue());

                 XSSFCell cell12 = row.getCell(12);
                if (cell12 == null) {
                    continue;
                }
                archive.setHirdate(cell12.getDateCellValue());
                //将对象放入集合*/
             archives.add(archive);

            }

           /* for (Archives a: archives) {
                System.out.println(a);
            }*/

           archService.add(archives);
        }

        return  "archives";
    }
}
