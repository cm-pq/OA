package com.ujiuye.datacollect.bean;

import com.ujiuye.indexvalue.bean.Indexvalue;

public class DataExtend  {
    private Datacollect datacollect;

    @Override
    public String toString() {
        return "DataExtend{" +
                "datacollect=" + datacollect +
                ", indexvalue=" + indexvalue +
                '}';
    }

    public Datacollect getDatacollect() {
        return datacollect;
    }

    public void setDatacollect(Datacollect datacollect) {
        this.datacollect = datacollect;
    }

    private Indexvalue indexvalue;

    public Indexvalue getIndexvalue() {
        return indexvalue;
    }

    public void setIndexvalue(Indexvalue indexvalue) {
        this.indexvalue = indexvalue;
    }
}
