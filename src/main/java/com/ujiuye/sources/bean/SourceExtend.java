package com.ujiuye.sources.bean;

import java.util.List;

public class SourceExtend extends Sources {
private boolean open;
//注意框架识别childer,不可随便起名
private List<SourceExtend> children;

    public boolean isOpen() {
        return open;
    }


    public void setOpen(boolean open) {
        this.open = open;
    }

    public List<SourceExtend> getChildren() {
        return children;
    }

    public void setChildren(List<SourceExtend> children) {
        this.children = children;
    }
}
