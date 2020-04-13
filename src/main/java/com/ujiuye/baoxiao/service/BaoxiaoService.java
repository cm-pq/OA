package com.ujiuye.baoxiao.service;

import com.ujiuye.baoxiao.bean.Baoxiao;
import com.ujiuye.baoxiao.bean.BaoxiaoExtend;
import com.ujiuye.baoxiao.bean.Expendituretype;

import java.util.List;

public interface BaoxiaoService {
    List<Baoxiao> show(Integer ek);

    List<Expendituretype> showType();

    void save(Baoxiao baoxiao);


    List<BaoxiaoExtend> xiao();

    BaoxiaoExtend shen(String ss);

    void shenpi(Integer bxstatus, String bxid, String result);
}
