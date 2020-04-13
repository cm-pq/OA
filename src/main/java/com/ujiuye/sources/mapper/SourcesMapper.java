package com.ujiuye.sources.mapper;

import com.ujiuye.sources.bean.RoleSourceExtend;
import com.ujiuye.sources.bean.SourceExtend;
import com.ujiuye.sources.bean.Sources;
import com.ujiuye.sources.bean.SourcesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SourcesMapper {
    int countByExample(SourcesExample example);

    int deleteByExample(SourcesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sources record);

    int insertSelective(Sources record);

    List<Sources> selectByExample(SourcesExample example);

    Sources selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sources record, @Param("example") SourcesExample example);

    int updateByExample(@Param("record") Sources record, @Param("example") SourcesExample example);

    int updateByPrimaryKeySelective(Sources record);

    int updateByPrimaryKey(Sources record);

    List<SourceExtend> tree(int i);


    List<SourceExtend> yy(@Param("roleid") Integer roleid, @Param("pid") int pid);
}