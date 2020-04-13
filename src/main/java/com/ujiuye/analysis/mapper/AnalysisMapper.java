package com.ujiuye.analysis.mapper;

import com.ujiuye.analysis.bean.Analysis;
import com.ujiuye.analysis.bean.AnalysisExample;
import com.ujiuye.project.bean.ProNeed;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnalysisMapper {
    int countByExample(AnalysisExample example);

    int deleteByExample(AnalysisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Analysis record);

    int insertSelective(Analysis record);

    List<Analysis> selectByExample(AnalysisExample example);

    Analysis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Analysis record, @Param("example") AnalysisExample example);

    int updateByExample(@Param("record") Analysis record, @Param("example") AnalysisExample example);

    int updateByPrimaryKeySelective(Analysis record);

    int updateByPrimaryKey(Analysis record);
    List<ProNeed> sel();
    List<ProNeed> moanpro();
}