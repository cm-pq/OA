package com.ujiuye.project.bean;

public class ProjectSearch {
    private Integer cid=0;
    private String keyword="";
    private Integer orderby=0;

    @Override
    public String toString() {
        return "projectSearch{" +
                "cid=" + cid +
                ", keyword='" + keyword + '\'' +
                ", orderby=" + orderby +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }
}
