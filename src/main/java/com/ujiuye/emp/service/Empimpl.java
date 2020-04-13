package com.ujiuye.emp.service;

import com.ujiuye.dept.bean.Dept;
import com.ujiuye.dept.mapper.DeptMapper;
import com.ujiuye.emp.bean.EmploExtend;
import com.ujiuye.emp.bean.Employee;
import com.ujiuye.emp.bean.EmployeeExample;
import com.ujiuye.emp.bean.QuanXian;
import com.ujiuye.emp.mapper.EmployeeMapper;
import com.ujiuye.emp_role.bean.EmpRole;
import com.ujiuye.emp_role.mapper.EmpRoleMapper;
import com.ujiuye.level.bean.Level;
import com.ujiuye.level.mapper.LevelMapper;
import com.ujiuye.position.bean.Position;
import com.ujiuye.position.mapper.PositionMapper;
import com.ujiuye.role.bean.Role;
import com.ujiuye.role.mapper.RoleMapper;
import com.ujiuye.sources.bean.RoleSourceExtend;
import com.ujiuye.sources.bean.RoleSources;
import com.ujiuye.sources.bean.RoleSourcesExample;
import com.ujiuye.sources.bean.SourceExtend;
import com.ujiuye.sources.mapper.RoleSourcesMapper;
import com.ujiuye.sources.mapper.SourcesMapper;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Empimpl  implements EmpService {
    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private PositionMapper positionMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private  DeptMapper deptMapper;
    @Resource
    private LevelMapper levelMapper;
    @Resource
    private EmpRoleMapper empRoleMapper;
    @Resource
    private RoleSourcesMapper roleSourcesMapper;
    @Resource
    private SourcesMapper sourcesMapper;

    public SourcesMapper getSourcesMapper() {
        return sourcesMapper;
    }

    public void setSourcesMapper(SourcesMapper sourcesMapper) {
        this.sourcesMapper = sourcesMapper;
    }

    public RoleSourcesMapper getRoleSourcesMapper() {

        return roleSourcesMapper;
    }

    public void setRoleSourcesMapper(RoleSourcesMapper roleSourcesMapper) {
        this.roleSourcesMapper = roleSourcesMapper;
    }

    public EmpRoleMapper getEmpRoleMapper() {
        return empRoleMapper;
    }

    public void setEmpRoleMapper(EmpRoleMapper empRoleMapper) {
        this.empRoleMapper = empRoleMapper;
    }

    public RoleMapper getRoleMapper() {
        return roleMapper;
    }

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public DeptMapper getDeptMapper() {
        return deptMapper;
    }

    public void setDeptMapper(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    public LevelMapper getLevelMapper() {
        return levelMapper;
    }

    public void setLevelMapper(LevelMapper levelMapper) {
        this.levelMapper = levelMapper;
    }

    public PositionMapper getPositionMapper() {
        return positionMapper;
    }

    public void setPositionMapper(PositionMapper positionMapper) {
        this.positionMapper = positionMapper;
    }

    public EmployeeMapper getEmployeeMapper() {
        return employeeMapper;
    }

    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }





    @Override
    public List<Employee> selectone() {
/*        //获取条件对象(表名加example)
        UserExample userExample = new UserExample();
        //创建内部类对象
        Criteria createCriteria = userExample.createCriteria();
        //设置条件
        Criteria andIdEqualTo = createCriteria.andIdEqualTo(1);*/
       EmployeeExample c = new EmployeeExample();
        EmployeeExample.Criteria criteria = c.createCriteria();
        EmployeeExample.Criteria criteria1 = criteria.andPFkEqualTo(4);
        return  employeeMapper.selectByExample(c);
    }

    @Override
    public Employee logon(String username, String pass) {
      Employee employee = employeeMapper.selectByname(username);
        //按照名称和密码查询用户
        //在数据库中保存的密码，通常是密文形式的，不是明文形式的；那么密码是经过加密处理的，
        //一般加密算法是不可逆的(由密码生成密文之后，不能再由密文返回原密码)
        //如果我们表中保存的密码是加密处理的，那么即使输入的密码是正确的，当把密码传到数据库中实现验证时，此时也验证不成功
        //此时该如何验证？
        //先在此处对密码进行加密，然后把用户名和加密的结果送到数据库，在数据库中验证
        //还可以先通过用户名把数据查回来，获取到数据库表中密文，再此处再把页面送来的密码进行加密，然后匹配密文和加密之后字符串
        if (employee != null) {
            String password = employee.getPassword();//获取到密码的密文
            //pass在此处应该有加密处理
            if (!password.equals(pass)) {
                return null;
            }

        }
   return employee;
    }
//用户展示
    @Override
    public List<EmploExtend> user() {

      List<EmploExtend> emploExtends =  employeeMapper.user();
        return emploExtends;
    }

    @Override
    public List<Position> getPosition() {
        return positionMapper.selectByExample(null);
    }

    @Override
    public List<Level> getLevel() {
        return levelMapper.selectByExample(null);
    }

    @Override
    public List<Dept> getDept() {
        return deptMapper.selectByExample(null);
    }

    @Override
    public List<Role> getRole() {
        return roleMapper.selectByExample(null);
    }

    @Override
    public void addEmp(Integer roleid, Employee employee) {
        employeeMapper.addEmp(employee);
        EmpRole empRole = new EmpRole();
        empRole.setRoleFk(roleid);
        empRole.setEmpFk(employee.getEid());
        empRoleMapper.insertSelective(empRole);
    }

    @Override
    public QuanXian quanxian(Integer eid) {

        QuanXian quanXian = new QuanXian();
        //获取员工信息
        Employee employee = employeeMapper.selectByPrimaryKey(eid);
        //通过eid获取中间表信息(role和employee)即给人添加角色信息,添加角色功能在添加人员那里
        EmpRole empRole = empRoleMapper.selectbyEid(eid);
       //通过中间表获取角色信息
        Integer roleFk = empRole.getRoleFk();
        Role role = roleMapper.selectByPrimaryKey(roleFk);
        //通过子查询来查找角色与资源中间表来获得都有哪些资源,再查找第二层pid=1,所属的资源有哪些,给其赋值,看配置文件和查数据库就会明白
        /*中心思想为通过查找到id来当做pid对照中间表查*/
        List<SourceExtend> sourceExtends = sourcesMapper.yy(role.getRoleid(), 1);
                          sourceExtends = change(role.getRoleid(), sourceExtends);
        quanXian.setEmployee(employee);
        quanXian.setRole(role);
        quanXian.setSourceExtends(sourceExtends);
        return quanXian;
    }

    @Override
    public List<Employee> all() {
        return employeeMapper.selectByExample(null);
    }


    private List<SourceExtend> change(Integer roleid,List<SourceExtend> sourcesExample) {
        if(sourcesExample != null && sourcesExample.size() > 0){
            for (SourceExtend s:sourcesExample) {
                //获取传过来的id
                Integer id = s.getId();
                //查找属于他这个id的子类,因为标注属于他这个id的字段为pid所以上面为了方便,用的同一种
                List<SourceExtend> sourceExtends = sourcesMapper.yy(roleid,id);
                /*给里面赋值*/
                s.setChildren(sourceExtends);
            }
        }
        return sourcesExample;
    }
}
