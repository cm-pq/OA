package com.ujiuye.evaluate.service;

import com.ujiuye.evaluate.bean.Evaluate;
import com.ujiuye.evaluate.mapper.EvaluateMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Evaimpl implements EvaService {
    @Resource
    private EvaluateMapper evaluateMapper;
    @Override
    public void add(Evaluate e) {

        evaluateMapper.insertSelective(e);

    }
}
