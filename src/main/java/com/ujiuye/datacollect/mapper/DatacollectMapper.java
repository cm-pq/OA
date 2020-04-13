package com.ujiuye.datacollect.mapper;

import com.ujiuye.datacollect.bean.Datacollect;
import com.ujiuye.datacollect.bean.DatacollectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DatacollectMapper {
    int countByExample(DatacollectExample example);

    int deleteByExample(DatacollectExample example);

    int deleteByPrimaryKey(Integer daid);

    int insert(Datacollect record);

    int insertSelective(Datacollect record);

    List<Datacollect> selectByExample(DatacollectExample example);

    Datacollect selectByPrimaryKey(Integer daid);

    int updateByExampleSelective(@Param("record") Datacollect record, @Param("example") DatacollectExample example);

    int updateByExample(@Param("record") Datacollect record, @Param("example") DatacollectExample example);

    int updateByPrimaryKeySelective(Datacollect record);

    int updateByPrimaryKey(Datacollect record);
}