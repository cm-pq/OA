package com.ujiuye.module.mapper;
import com.ujiuye.module.bean.ModelExtend;
import com.ujiuye.module.bean.Modul;
import com.ujiuye.module.bean.ModuleExampl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleMapper {
    int countByExample(ModuleExampl example);

    int deleteByExample(ModuleExampl example);

    int deleteByPrimaryKey(Integer id);

    int insert(Modul record);

    int insertSelective(Modul record);

    List<Modul> selectByExample(ModuleExampl example);

    Modul selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Modul record, @Param("example") ModuleExampl example);

    int updateByExample(@Param("record") Modul record, @Param("example") ModuleExampl example);

    int updateByPrimaryKeySelective(Modul record);

    int updateByPrimaryKey(Modul record);

    List<ModelExtend> show();
}