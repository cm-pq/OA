package com.ujiuye.msg.service;

import com.ujiuye.msg.bean.Msg;

import java.util.List;

public interface MsgService {
    List<Msg> show();

    void saveMsg(Msg msg);
}
