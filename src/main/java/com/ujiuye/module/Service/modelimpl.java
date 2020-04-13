package com.ujiuye.module.Service;

import com.ujiuye.module.bean.ModelExtend;
import com.ujiuye.module.mapper.ModuleMapper;
import com.ujiuye.project.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class modelimpl implements ModelService {
    @Resource
private ModuleMapper moduleMapper;

    public ModuleMapper getModuleMapper() {
        return moduleMapper;
    }

    public void setModuleMapper(ModuleMapper moduleMapper) {
        this.moduleMapper = moduleMapper;
    }

    @Override
    public List<ModelExtend> show() {
        return moduleMapper.show();
    }
}
