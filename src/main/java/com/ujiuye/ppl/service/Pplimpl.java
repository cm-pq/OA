package com.ujiuye.ppl.service;

import com.ujiuye.ppl.bean.Ppl;
import com.ujiuye.ppl.mapper.PplMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Pplimpl implements PplService {
    @Resource
   private PplMapper pplMapper;

    public PplMapper getPplMapper() {
        return pplMapper;
    }

    public void setPplMapper(PplMapper pplMapper) {
        this.pplMapper = pplMapper;
    }

    @Override
    public void add(Ppl ppl) {
        pplMapper.insertSelective(ppl);
    }

    @Override
    public List<Ppl> show() {
        return pplMapper.selectByExample(null);
    }

    @Override
    public void delete(int[] id) {
        pplMapper.delete(id);
    }
}
