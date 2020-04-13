package com.ujiuye.datacollect.service;

import com.ujiuye.datacollect.bean.DataExtend;
import com.ujiuye.datacollect.bean.Datacollect;
import com.ujiuye.datacollect.bean.DatacollectExample;
import com.ujiuye.datacollect.mapper.DatacollectMapper;
import com.ujiuye.indexvalue.bean.Indexvalue;
import com.ujiuye.indexvalue.bean.IndexvalueExample;
import com.ujiuye.indexvalue.mapper.IndexvalueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class Dataimpl implements DataService{
    @Resource
    private DatacollectMapper datacollectMapper;
    @Resource
    private IndexvalueMapper indexvalueMapper;

    public IndexvalueMapper getIndexvalueMapper() {
        return indexvalueMapper;
    }

    public void setIndexvalueMapper(IndexvalueMapper indexvalueMapper) {
        this.indexvalueMapper = indexvalueMapper;
    }

    public DatacollectMapper getDatacollectMapper() {
        return datacollectMapper;
    }

    public void setDatacollectMapper(DatacollectMapper datacollectMapper) {
        this.datacollectMapper = datacollectMapper;
    }

    @Override
    public List<Datacollect> caishow() {
        List<Datacollect> datacollects = datacollectMapper.selectByExample(null);

        return datacollects;
    }

    @Override
    public DataExtend selectone(Integer cname) {
        DataExtend dataExtend = new DataExtend();
        Datacollect datacollect = datacollectMapper.selectByPrimaryKey(cname);
        dataExtend.setDatacollect(datacollect);
        IndexvalueExample indexvalueExample = new IndexvalueExample();
        IndexvalueExample.Criteria criteria = indexvalueExample.createCriteria();
        IndexvalueExample.Criteria criteria1 = criteria.andComnameFkEqualTo(cname);
        List<Indexvalue> indexvalues = indexvalueMapper.selectByExample(indexvalueExample);
        for (Indexvalue i:indexvalues) {
            dataExtend.setIndexvalue(i);
        }


        return dataExtend;
    }

    @Override
    public List<Datacollect> zhu() {

        DatacollectExample datacollectExample = new DatacollectExample();
        DatacollectExample.Criteria criteria = datacollectExample.createCriteria();
        criteria.andDacnameEqualTo("东华软件");
        List<Datacollect> datacollects = datacollectMapper.selectByExample(datacollectExample);
        return datacollects;
    }
}
