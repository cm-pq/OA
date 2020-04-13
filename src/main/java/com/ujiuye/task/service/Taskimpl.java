package com.ujiuye.task.service;

import com.ujiuye.function.bean.Function;
import com.ujiuye.function.mapper.FunctionMapper;
import com.ujiuye.task.bean.TaskExtend;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.ReturnType;

import javax.annotation.Resource;
import java.util.List;
@Service
public class Taskimpl implements TaskService {
    @Resource
    private FunctionMapper functionMapper;

    public FunctionMapper getFunctionMapper() {
        return functionMapper;
    }

    public void setFunctionMapper(FunctionMapper functionMapper) {
        this.functionMapper = functionMapper;
    }

    @Override
    public TaskExtend yi(Integer fun) {
        TaskExtend taskExtend = new TaskExtend();
        List<Function> model = functionMapper.model(fun);
        taskExtend.setFunctions(model);
        System.out.println(taskExtend);
        return  taskExtend;
    }
}
