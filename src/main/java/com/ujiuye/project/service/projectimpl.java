package com.ujiuye.project.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.analysis.bean.Analysis;
import com.ujiuye.analysis.mapper.AnalysisMapper;
import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.CustomerExample;
import com.ujiuye.cus.mapper.CustomerMapper;
import com.ujiuye.emp.bean.Employee;
import com.ujiuye.emp.bean.EmployeeExample;
import com.ujiuye.emp.mapper.EmployeeMapper;
import com.ujiuye.project.bean.ProNeed;
import com.ujiuye.project.bean.Project;
import com.ujiuye.project.bean.ProjectExample;
import com.ujiuye.project.bean.ProjectSearch;
import com.ujiuye.project.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class projectimpl implements ProjectService {
    @Resource
    private ProjectMapper projectMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private AnalysisMapper analysisMapper;
    @Override
    public PageInfo<Project> show(Integer currentPage) {
        PageHelper.startPage(currentPage,2);
        //按条件查找数据
        List<Project>  list = projectMapper.show();
        for (Project p:list) {
            Customer customer = customerMapper.selectByPrimaryKey(p.getComname());
            p.setCustomer(customer);
            Employee employee = employeeMapper.selectByPrimaryKey(p.getEmpFk());
            p.setEmployee(employee);
        }
        PageInfo<Project> projectEXPageInfo = new PageInfo<>(list,3);

        return projectEXPageInfo ;
    }

    @Override
    public boolean insert(Project project) {
        int i = projectMapper.insertSelective(project);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public Project look(Integer pid) {
        Project project = projectMapper.selectByPrimaryKey(pid);
        Customer customer = customerMapper.selectByPrimaryKey(project.getComname());
        project.setCustomer(customer);
        Employee employee = employeeMapper.selectByPrimaryKey(project.getEmpFk());
        project.setEmployee(employee);
        return project;
    }

    @Override
    public void updata(Project project) {
        projectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    public void del(List<Integer> pid) {
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        criteria.andPidIn(pid);
        int i = projectMapper.deleteByExample(projectExample);
        if (i>0) {
            System.out.println("删除成功");
        }
    }

    @Override
    public PageInfo<Project> searce(ProjectSearch projectSearch, Integer currentPage) {
        /*PageHelper.startPage(currentPage,2);*/
        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria1 = customerExample.createCriteria();
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria2 = employeeExample.createCriteria();
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria3 = projectExample.createCriteria();
        List<Project> projects = new ArrayList<>();
       //所有的都有
        boolean all = (projectSearch.getCid()==0 && projectSearch.getKeyword()==""||projectSearch.getKeyword()==null);
        boolean cid1=(projectSearch.getCid()==1);
        boolean cid2=(projectSearch.getCid()==2);

        if (all) {
            System.out.println("s1");
                  projects = projectMapper.selectByExample(null);
            for (Project p : projects) {
                Customer customer = customerMapper.selectByPrimaryKey(p.getComname());
                p.setCustomer(customer);
                Employee employee = employeeMapper.selectByPrimaryKey(p.getEmpFk());
                p.setEmployee(employee);
            }
        }

    if (cid1) {
        System.out.println("s2"+projectSearch.getKeyword());
        ProjectExample.Criteria criteria = criteria3.andPnameLike(projectSearch.getKeyword());
        projects = projectMapper.selectByExample(projectExample);
        System.out.println("结果为"+projects);
        for (Project p : projects) {
            Customer customer = customerMapper.selectByPrimaryKey(p.getComname());
            p.setCustomer(customer);
            Employee employee = employeeMapper.selectByPrimaryKey(p.getEmpFk());
            p.setEmployee(employee);
        }
    }
     if (cid2){
         System.out.println("s3"+projectSearch.getKeyword());
         EmployeeExample.Criteria criteria4 = criteria2.andEnameLike(projectSearch.getKeyword());
         List<Employee> list = employeeMapper.selectByExample(employeeExample);
         for (Employee e:list ) {
             ProjectExample.Criteria criteria5 = criteria3.andEmpFk1EqualTo(e.getEid());
            projects = projectMapper.selectByExample(projectExample);
             for (Project p:projects ) {
                 //以同一个em搜,将同一个em赋予它
                 p.setEmployee(e);
                 Employee employee = employeeMapper.selectByPrimaryKey(p.getEmpFk());
                 p.setEmployee(employee);
             }
         }
     }

        PageInfo<Project> projectEXPageInfo = new PageInfo<>(projects,3);
        return projectEXPageInfo;
    }

    @Override
    public List<Project> sel(Integer mark) {
        return projectMapper.sel(mark);
    }

    @Override
    public void add(Analysis analysis) {
        analysisMapper.insertSelective(analysis);
    }

    @Override
    public List<ProNeed> showNeed() {
        return analysisMapper.sel();
    }
}
