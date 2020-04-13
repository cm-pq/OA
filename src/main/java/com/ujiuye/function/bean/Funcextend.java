package com.ujiuye.function.bean;


import com.ujiuye.analysis.bean.Analysis;
import com.ujiuye.module.bean.Modul;

import java.util.List;


public class Funcextend extends Function {
    private List<Modul>  moduls;
    private Analysis analysis;

    public Analysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

    @Override
    public String toString() {
        return "Funcextend{" +
                "moduls=" + moduls +
                ", analysis=" + analysis +
                '}';
    }

    public List<Modul> getModuls() {
        return moduls;
    }

    public void setModuls(List<Modul> moduls) {
        this.moduls = moduls;
    }
}
