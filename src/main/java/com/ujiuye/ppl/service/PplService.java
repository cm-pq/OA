package com.ujiuye.ppl.service;

import com.ujiuye.ppl.bean.Ppl;

import java.util.List;

public interface PplService {
    void add(Ppl ppl);

    List<Ppl> show();

    void delete(int[] id);
}
