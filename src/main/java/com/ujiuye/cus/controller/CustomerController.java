package com.ujiuye.cus.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.CustomerVo;
import com.ujiuye.cus.service.CustomerService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Index;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private JedisPool pool;


   @RequestMapping("cust")
  /* public String goodsShow(Model model) throws IOException {
       List<Customer>goodsList = null;
        *//*当客户请求商品信息的时候，controller层要进行判断，先到redis中查，
        如果redis中查到了商品列表数据，那么就把redis中保存的数据读回来，因为从redis查数据送回，比到数据库查数据送回要快；
        如果redis中没有查到商品列表数据，那么就再到数据库查，数据库查到之后再送回，在redis也保存下来
        *//*
       //先获取到redis的连接对象
       Jedis resource = pool.getResource();
       //再根据key，从redis库中获取指定key的值
       String key = "goods_list";
       //注意在redis中数据是如何保存的？json串的方式保存、序列化方式保存
       String json = resource.get(key);

       ObjectMapper om = new ObjectMapper();
//        byte[] bytes = resource.get(key.getBytes());
       if(json != null && json.length() > 0){
           //如果获取到了，那么送回给用户//无法用于分页,因为key值一样
           //把json串转回对象(单一对象、集合对象)
           goodsList = om.readValue(json, getCollectionType(List.class, Customer.class));
           System.out.println("****************************************");
           System.out.println("从redis库中获取到了数据，转json串为list给用户送回");
           System.out.println("****************************************");
       }else{
           //如果没有获取到，那么到数据库查询，返回数据送回用户、redis中保存
           goodsList = customerService.selectAl();
           String value = om.writeValueAsString(goodsList);
           resource.set(key,value);

           System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
           System.out.println("从redis库中没有获取到数据，是去数据库查询回来的数据给客户送回，又保存到redis中一份");
           System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
       }
       //释放资源
       resource.close();

       model.addAttribute("goodsList",goodsList);
       return "ppl";
   }*/

    public ModelAndView selectaa(ModelAndView modelAndView) throws IOException {
       List<Customer> customers = null;
       //先获取redis连接对象
       Jedis resource = pool.getResource();
       //根据key值获取指定的value值
       String key = "customer-show";
       String json = resource.get(key);
       System.out.println("来了");
       ObjectMapper om = new ObjectMapper();
       //如果里面有值,那就送回给用户,否则查询后存redis同时返回给用户不能用于分页,因为key值相同
       if (json != null && json.length() > 0) {
           //把json字符串转为对象
           customers = om.readValue(json, getCollectionType(List.class, Customer.class));
           System.out.println(3);
       } else {


           customers = customerService.selectAl();
           String s1 = om.writeValueAsString(customers);
           resource.set(key, s1);

       }
       resource.close();
       modelAndView.setViewName("ppl");

       modelAndView.addObject("pageinfo", customers);
       return modelAndView;
   }
   @RequestMapping("customer-show")
   public ModelAndView select(ModelAndView modelAndView, @RequestParam(defaultValue = "1") int currentPage) throws IOException {
       PageInfo<Customer> customerPageInfo = customerPageInfo = customerService.selectAll(currentPage);
       modelAndView.setViewName("customer");
       modelAndView.addObject("pageinfo", customerPageInfo);
       return modelAndView;
   }

    @RequestMapping("add")
    public String add(Customer customer) {

        boolean c = customerService.add(customer);

        return "redirect:/customer/customer-show";
    }

    @RequestMapping("updata")
    public String data(Integer id, Model model, String func) {
        Customer customer = customerService.select(id);
        model.addAttribute("customer", customer);
        String a = "edit";
        if (func.equals(a)) {
            return "customer-edit";
        }
        return "customer-look";
    }

    @RequestMapping("updatabyid")
    public String updata(Customer customer, Model model) {
        System.out.println(customer);
        boolean c = customerService.updata(customer);

        return "redirect:/customer/customer-show";


    }

    @RequestMapping("delete")
    public String delete(@RequestParam List<Integer> id) {
        System.out.println(id);
        customerService.delect(id);

        return "redirect:/customer/customer-show";
    }

    @RequestMapping("outExcel")
    public String outExcel(HttpSession httpSession) {
        PageInfo<Customer>  pageInfo = (PageInfo<Customer> ) httpSession.getAttribute("list");
        System.out.println("值为"+pageInfo);
        List<Customer> list = pageInfo.getList();
//导出excel步骤
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("客户信息表");
//第一行表头
        HSSFRow row = hssfSheet.createRow(0);
        //创建单元格
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("编号");
        HSSFCell cell1 = row.createCell(1);
        cell1.setCellValue("公司名称");
        HSSFCell cell2 = row.createCell(2);
        cell2.setCellValue("负责人名称");
        HSSFCell cell3 = row.createCell(3);
        cell3.setCellValue("公司地址");
        HSSFCell cell4 = row.createCell(4);
        cell4.setCellValue("电话");
        for (int i = 0; i < list.size(); i++) {

            Customer customer = list.get(i);
            //创建第二行
            HSSFRow row1 = hssfSheet.createRow(i + 1);
            HSSFCell cell7 = row1.createCell(0);
            cell7.setCellValue(customer.getId() + "");
            HSSFCell cell8 = row1.createCell(1);
            cell8.setCellValue(customer.getComname());
            HSSFCell cell9 = row1.createCell(2);
            cell9.setCellValue(customer.getCompanyperson());
            HSSFCell cell0 = row1.createCell(3);
            cell0.setCellValue(customer.getComaddress());
            HSSFCell cell22 = row1.createCell(4);
            cell22.setCellValue(customer.getComphone());


        }
        try {
            // js  prompt("输入路径")
            FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\客户信息表.xls");
            hssfWorkbook.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/customer/customer-show";
    }
    @RequestMapping("/search")
    public String search(Model model,CustomerVo customerVo,@RequestParam(defaultValue = "1") int currentPage){
        System.out.println(customerVo);
         PageInfo<Customer> pageInfo = customerService.search(currentPage,customerVo);
          model.addAttribute("pageinfo",pageInfo);
        return "customer";
    }
      @RequestMapping("selectcname")
      @ResponseBody
      public List<Customer> selectname(){


      List<Customer> c =  customerService.selectname();

        return c;
}
@RequestMapping("selectone")
    @ResponseBody
    public Customer selectone(Integer id){
      return customerService.selectone(id);


}
//集合转对象工具类

    public JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }




}