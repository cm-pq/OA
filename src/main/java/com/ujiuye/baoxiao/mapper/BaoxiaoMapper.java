package com.ujiuye.baoxiao.mapper;

import com.ujiuye.baoxiao.bean.Baoxiao;
import com.ujiuye.baoxiao.bean.BaoxiaoExample;
import com.ujiuye.baoxiao.bean.BaoxiaoExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaoxiaoMapper {
    int countByExample(BaoxiaoExample example);

    int deleteByExample(BaoxiaoExample example);

    int deleteByPrimaryKey(String bxid);

    int insert(Baoxiao record);

    int insertSelective(Baoxiao record);

    List<Baoxiao> selectByExample(BaoxiaoExample example);

    Baoxiao selectByPrimaryKey(String bxid);

    int updateByExampleSelective(@Param("record") Baoxiao record, @Param("example") BaoxiaoExample example);

    int updateByExample(@Param("record") Baoxiao record, @Param("example") BaoxiaoExample example);

    int updateByPrimaryKeySelective(Baoxiao record);

    int updateByPrimaryKey(Baoxiao record);

    List<BaoxiaoExtend> xiao();

    BaoxiaoExtend shen(String ss);
}