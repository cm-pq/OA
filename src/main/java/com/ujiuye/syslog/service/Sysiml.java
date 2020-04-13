package com.ujiuye.syslog.service;

import com.ujiuye.syslog.bean.Syslog;
import com.ujiuye.syslog.mapper.SyslogMapper;
import com.ujiuye.syslog.service.SyslogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class Sysiml implements SyslogService {
    @Resource
    private SyslogMapper syslogMapper;

    @Override
    public String toString() {
        return "Sysiml{" +
                "syslogMapper=" + syslogMapper +
                '}';
    }

    @Override
    public void save(Syslog syslog) {
       syslogMapper.insertSelective(syslog);
    }
}
