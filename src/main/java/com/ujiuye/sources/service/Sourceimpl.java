package com.ujiuye.sources.service;

import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;
import com.ujiuye.role.bean.Role;
import com.ujiuye.role.mapper.RoleMapper;
import com.ujiuye.sources.bean.*;
import com.ujiuye.sources.mapper.RoleSourcesMapper;
import com.ujiuye.sources.mapper.SourcesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class Sourceimpl implements SourceService {
    @Resource
    private SourcesMapper sourcesMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleSourcesMapper roleSourcesMapper;

    public SourcesMapper getSourcesMapper() {
        return sourcesMapper;
    }

    public void setSourcesMapper(SourcesMapper sourcesMapper) {
        this.sourcesMapper = sourcesMapper;
    }

    public RoleMapper getRoleMapper() {
        return roleMapper;
    }

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }



    @Override
    public List<SourceExtend> tree() {
        //查找根
        List<SourceExtend> sourcesExample =  sourcesMapper.tree(0);
      //调用方法,将他的id传进去
        return change(sourcesExample);
    }

    @Override
    public void addRole(String sourcesid, Role role) {
    roleMapper.insertfid(role);
    Integer cc = role.getRoleid();
        String[] split = sourcesid.split(",");
        for (int i = 0;i<split.length;i++){
            Integer spilt = Integer.valueOf(split[i]);
            int a =spilt;
            RoleSources roleSources = new RoleSources();
            roleSources.setRsdis("所有"+a+"的权限");
            roleSources.setRoleid(cc);
            roleSources.setSid(a);
            roleSourcesMapper.insertSelective(roleSources);
        }


    }

    @Override
    public RoleSourceExtend up(Integer roleid) {
         RoleSourceExtend roleSourceExtend = new RoleSourceExtend();
        Role role = roleMapper.selectByPrimaryKey(roleid);
        RoleSourcesExample roleSourcesExample = new RoleSourcesExample();
        RoleSourcesExample.Criteria criteria = roleSourcesExample.createCriteria();
        criteria.andRoleidEqualTo(roleid);
        List<RoleSources> roleSources = roleSourcesMapper.selectByExample(roleSourcesExample);
        roleSourceExtend.setRoleSources(roleSources);
        roleSourceExtend.setRole(role);
        return roleSourceExtend;
    }

    @Override
    public RoleSourceExtend updata() {
        return null;
    }

    @Override
    public void updataInfo(String sourcesid, Role role) {
        //先删除
        roleSourcesMapper.deleteByPrimaryKey(role.getRoleid());
        //修改
        roleMapper.updateByPrimaryKey(role);
        //添加
        int c =role.getRoleid();
        String[] split = sourcesid.split(",");
        for (int i = 0;i<split.length;i++){
            Integer spilt = Integer.valueOf(split[i]);
            int a =spilt;
            RoleSources roleSources = new RoleSources();
            roleSources.setRsdis("所有"+a+"的权限");
            roleSources.setRoleid(c);
            roleSources.setSid(a);
            roleSourcesMapper.insertSelective(roleSources);
        }




    }

    @Override
    public void add(Sources sources) {
        sourcesMapper.insertSelective(sources);
    }

    @Override
    public boolean delete(Integer id) {
        int i = sourcesMapper.deleteByPrimaryKey(id);
        if(i>0){

            return true;
        }
        return false;
    }

    @Override
    public Sources getOneById(Integer id) {

        return sourcesMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Sources sources) {
        sourcesMapper.updateByPrimaryKeySelective(sources);
    }


    private List<SourceExtend> change(List<SourceExtend> sourcesExample) {
        if(sourcesExample != null && sourcesExample.size() > 0){
            for (SourceExtend s:sourcesExample) {
                //获取传过来的id
                Integer id = s.getId();
                //查找属于他这个id的子类,因为标注属于他这个id的字段为pid所以上面为了方便,用的同一种
                List<SourceExtend> sourceExtends = sourcesMapper.tree(id);
                /*给里面赋值*/
                s.setChildren(sourceExtends);
                //递归调用
                change(sourceExtends);

            }
        }
        return sourcesExample;
    }
}
