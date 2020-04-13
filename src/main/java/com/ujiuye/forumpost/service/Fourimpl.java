package com.ujiuye.forumpost.service;

import com.ujiuye.emp.bean.Employee;
import com.ujiuye.emp.mapper.EmployeeMapper;
import com.ujiuye.evaluate.bean.Evaluate;
import com.ujiuye.evaluate.bean.EvaluateExample;
import com.ujiuye.evaluate.bean.EvaluateExtend;
import com.ujiuye.evaluate.mapper.EvaluateMapper;
import com.ujiuye.forumpost.bean.ForumExtend;
import com.ujiuye.forumpost.bean.Forumpost;
import com.ujiuye.forumpost.mapper.ForumpostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class Fourimpl implements FourService {
    @Resource
    private ForumpostMapper forumpostMapper;
    @Resource
    private EvaluateMapper evaluateMapper;
    @Resource
    private EmployeeMapper employeeMapper;

    public EvaluateMapper getEvaluateMapper() {
        return evaluateMapper;
    }

    public void setEvaluateMapper(EvaluateMapper evaluateMapper) {
        this.evaluateMapper = evaluateMapper;
    }


    public ForumpostMapper getForumpostMapper() {

        return forumpostMapper;
    }

    public void setForumpostMapper(ForumpostMapper forumpostMapper) {
        this.forumpostMapper = forumpostMapper;
    }

    @Override
    public List<Forumpost> show() {
        return forumpostMapper.selectByExample(null);
    }

    @Override
    public void add(Forumpost forumpost) {
        forumpostMapper.insertSelective(forumpost);
    }

    @Override
    public ForumExtend look(Integer id) {

        ForumExtend forumExtend = new ForumExtend();
        //根据帖子id查询帖子信息,获取发布人信息
        Forumpost forumpost = forumpostMapper.selectByPrimaryKey(id);
        //查找发布人
        forumExtend.setEmployee(employeeMapper.selectByPrimaryKey(forumpost.getEmpFk3()));
        /*上面的是查帖子信息.其实可以在一个类里面,我把他单独放出来*/
        //下面才是正题，通过帖子id获取evaid为null的回帖一级评论
        List<EvaluateExtend> evaluates = evaluateMapper.selectByem(id);
        //调用递归
        List<EvaluateExtend> evaluateExtends = change(evaluates);

        //给其赋值
        forumExtend.setEvaluateEXtend(evaluates);
        forumExtend.setForumpost(forumpost);
        return forumExtend;
    }

    //将查到的一级评论放进方法,获取他的主键
    private List<EvaluateExtend> change(List<EvaluateExtend> evaluates) {
        List<EvaluateExtend> er = null;

        if (evaluates.size() > 0) {
            for (EvaluateExtend e : evaluates) {
                //这是个集合
                System.out.println("主键为"+e.getEvaid());
                er = evaluateMapper.er(e.getEvaid());
                for (EvaluateExtend evaluateExtend: er) {
                    System.out.println(evaluateExtend.getEvacontent());
                }
                //给集合里面的集合赋值
                e.setChouduri(er);
                change(er);
            }

        }
        return er;

    }
}
