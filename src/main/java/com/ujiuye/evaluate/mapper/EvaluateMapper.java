package com.ujiuye.evaluate.mapper;

import com.ujiuye.evaluate.bean.Evaluate;
import com.ujiuye.evaluate.bean.EvaluateExample;
import com.ujiuye.evaluate.bean.EvaluateExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluateMapper {
    int countByExample(EvaluateExample example);

    int deleteByExample(EvaluateExample example);

    int deleteByPrimaryKey(Integer evaid);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    List<Evaluate> selectByExample(EvaluateExample example);

    Evaluate selectByPrimaryKey(Integer evaid);

    int updateByExampleSelective(@Param("record") Evaluate record, @Param("example") EvaluateExample example);

    int updateByExample(@Param("record") Evaluate record, @Param("example") EvaluateExample example);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);

    List<EvaluateExtend> selectByem(Integer id);
    List<EvaluateExtend> er(Integer evaid_fk);
}