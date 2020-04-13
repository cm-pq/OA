package com.ujiuye.archives.service;

import com.ujiuye.analysis.mapper.AnalysisMapper;
import com.ujiuye.archives.bean.Archives;
import com.ujiuye.archives.mapper.ArchivesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class Archimpl implements archService {
    @Resource
    private ArchivesMapper archivesMapper;
    @Override
    public void add(List<Archives> archives) {
        for (Archives a:archives) {
            archivesMapper.insertSelective(a);
        }
    }
}
