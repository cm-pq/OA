package com.ujiuye.datacollect.service;

import com.ujiuye.datacollect.bean.DataExtend;
import com.ujiuye.datacollect.bean.Datacollect;

import java.util.List;

public interface DataService {
    List<Datacollect> caishow();

    DataExtend selectone(Integer cname);

    List<Datacollect> zhu();
}
