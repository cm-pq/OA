package com.ujiuye.baoxiao.service;

import com.ujiuye.baoxiao.bean.*;
import com.ujiuye.baoxiao.mapper.BaoxiaoMapper;
import com.ujiuye.baoxiao.mapper.BaoxiaoreplyMapper;
import com.ujiuye.baoxiao.mapper.ExpendituretypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class Biaoxiaoimpl implements BaoxiaoService {
    @Resource
    private  BaoxiaoMapper baoxiaoMapper;
    @Resource
    private BaoxiaoreplyMapper baoxiaoreplyMapper;
    @Resource
    private ExpendituretypeMapper expendituretypeMapper;

    public ExpendituretypeMapper getExpendituretypeMapper() {
        return expendituretypeMapper;
    }

    public void setExpendituretypeMapper(ExpendituretypeMapper expendituretypeMapper) {
        this.expendituretypeMapper = expendituretypeMapper;
    }

    public BaoxiaoreplyMapper getBaoxiaoreplyMapper() {
        return baoxiaoreplyMapper;
    }

    public void setBaoxiaoreplyMapper(BaoxiaoreplyMapper baoxiaoreplyMapper) {
        this.baoxiaoreplyMapper = baoxiaoreplyMapper;
    }

    public BaoxiaoMapper getBaoxiaoMapper() {
        return baoxiaoMapper;
    }

    public void setBaoxiaoMapper(BaoxiaoMapper baoxiaoMapper) {
        this.baoxiaoMapper = baoxiaoMapper;
    }



    @Override
    public List<Baoxiao> show(Integer ek) {
        BaoxiaoExample baoxiaoExample = new BaoxiaoExample();
        BaoxiaoExample.Criteria criteria = baoxiaoExample.createCriteria();
        criteria.andEmpFkEqualTo(ek);
        List<Baoxiao> baoxiaos = baoxiaoMapper.selectByExample(baoxiaoExample);
        return baoxiaos;
    }

    @Override
    public List<Expendituretype> showType() {
        List<Expendituretype> expendituretypes = expendituretypeMapper.selectByExample(null);
        return expendituretypes;
    }

    @Override
    public void save(Baoxiao baoxiao) {
        baoxiaoMapper.insertSelective(baoxiao);
    }

    @Override
    public List<BaoxiaoExtend> xiao() {
      List<BaoxiaoExtend> baoxiaoExtends =  baoxiaoMapper.xiao();
        return baoxiaoExtends;
    }

    @Override
    public BaoxiaoExtend shen(String ss) {
       BaoxiaoExtend baoxiaoExtend = baoxiaoMapper.shen(ss);
        return baoxiaoExtend;
    }

    @Override
    public void shenpi(Integer bxstatus, String bxid, String result) {
        Baoxiao baoxiao = new Baoxiao();
        baoxiao.setBxid(bxid);
        baoxiao.setBxstatus(bxstatus);
        baoxiaoMapper.updateByPrimaryKeySelective(baoxiao);
        Baoxiaoreply baoxiaoreply = new Baoxiaoreply();
        baoxiaoreply.setContent(result);
        baoxiaoreply.setBaoxiaoFk(bxid);
        baoxiaoreply.setReplytime(new Date());
        baoxiaoreplyMapper.insertSelective(baoxiaoreply);

    }
}

