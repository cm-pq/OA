package com.ujiuye.function.service;

import com.ujiuye.analysis.bean.Analysis;
import com.ujiuye.analysis.mapper.AnalysisMapper;
import com.ujiuye.function.bean.Funcextend;
import com.ujiuye.function.mapper.FunctionMapper;
import com.ujiuye.module.bean.Modul;
import com.ujiuye.module.bean.ModuleExampl;
import com.ujiuye.module.mapper.ModuleMapper;
import com.ujiuye.project.bean.Project;
import com.ujiuye.project.bean.ProjectExample;
import com.ujiuye.project.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Funcimpl implements FuncService {
    @Resource
    private ProjectMapper projectMapper;
    @Resource
    private AnalysisMapper analysisMapper;
    @Resource
    private ModuleMapper moduleMapper;


    @Override
    public Funcextend addyi(Integer l) {
        Funcextend funcextend = new Funcextend();
        Analysis analysis = analysisMapper.selectByPrimaryKey(l);
         funcextend.setAnalysis(analysis);
        ModuleExampl moduleExampl =new ModuleExampl();
        ModuleExampl.Criteria criteria = moduleExampl.createCriteria();
        ModuleExampl.Criteria criteria1 = criteria.andAnalysisFkEqualTo(l);
        List<Modul> moduls = moduleMapper.selectByExample(moduleExampl);
        funcextend.setModuls(moduls);
        return funcextend;
    }

    @Override
    public List<Project> selp() {
        return projectMapper.selectByExample(null);

    }


}
