package com.ujiuye.baoxiao.mapper;

import com.ujiuye.baoxiao.bean.Expendituretype;
import com.ujiuye.baoxiao.bean.ExpendituretypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpendituretypeMapper {
    int countByExample(ExpendituretypeExample example);

    int deleteByExample(ExpendituretypeExample example);

    int deleteByPrimaryKey(Integer etid);

    int insert(Expendituretype record);

    int insertSelective(Expendituretype record);

    List<Expendituretype> selectByExample(ExpendituretypeExample example);

    Expendituretype selectByPrimaryKey(Integer etid);

    int updateByExampleSelective(@Param("record") Expendituretype record, @Param("example") ExpendituretypeExample example);

    int updateByExample(@Param("record") Expendituretype record, @Param("example") ExpendituretypeExample example);

    int updateByPrimaryKeySelective(Expendituretype record);

    int updateByPrimaryKey(Expendituretype record);
}