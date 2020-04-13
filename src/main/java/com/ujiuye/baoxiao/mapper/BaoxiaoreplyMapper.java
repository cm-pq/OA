package com.ujiuye.baoxiao.mapper;

import com.ujiuye.baoxiao.bean.Baoxiaoreply;
import com.ujiuye.baoxiao.bean.BaoxiaoreplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaoxiaoreplyMapper {
    int countByExample(BaoxiaoreplyExample example);

    int deleteByExample(BaoxiaoreplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Baoxiaoreply record);

    int insertSelective(Baoxiaoreply record);

    List<Baoxiaoreply> selectByExample(BaoxiaoreplyExample example);

    Baoxiaoreply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Baoxiaoreply record, @Param("example") BaoxiaoreplyExample example);

    int updateByExample(@Param("record") Baoxiaoreply record, @Param("example") BaoxiaoreplyExample example);

    int updateByPrimaryKeySelective(Baoxiaoreply record);

    int updateByPrimaryKey(Baoxiaoreply record);
     List<Baoxiaoreply> baoxiaofk(String a);
}