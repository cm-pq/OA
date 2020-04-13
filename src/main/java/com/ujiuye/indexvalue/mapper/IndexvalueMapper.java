package com.ujiuye.indexvalue.mapper;

import com.ujiuye.indexvalue.bean.Indexvalue;
import com.ujiuye.indexvalue.bean.IndexvalueExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndexvalueMapper {
    int countByExample(IndexvalueExample example);

    int deleteByExample(IndexvalueExample example);

    int deleteByPrimaryKey(Integer inId);

    int insert(Indexvalue record);

    int insertSelective(Indexvalue record);

    List<Indexvalue> selectByExample(IndexvalueExample example);

    Indexvalue selectByPrimaryKey(Integer inId);

    int updateByExampleSelective(@Param("record") Indexvalue record, @Param("example") IndexvalueExample example);

    int updateByExample(@Param("record") Indexvalue record, @Param("example") IndexvalueExample example);

    int updateByPrimaryKeySelective(Indexvalue record);

    int updateByPrimaryKey(Indexvalue record);
}