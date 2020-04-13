package com.ujiuye.ppl.mapper;

import com.ujiuye.ppl.bean.Ppl;
import com.ujiuye.ppl.bean.PplExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PplMapper {
    int countByExample(PplExample example);

    int deleteByExample(PplExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Ppl record);

    int insertSelective(Ppl record);

    List<Ppl> selectByExample(PplExample example);

    Ppl selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Ppl record, @Param("example") PplExample example);

    int updateByExample(@Param("record") Ppl record, @Param("example") PplExample example);

    int updateByPrimaryKeySelective(Ppl record);

    int updateByPrimaryKey(Ppl record);

    void delete(int[] id);
}