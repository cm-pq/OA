package com.ujiuye.msg.service;

import com.ujiuye.msg.bean.Msg;
import com.ujiuye.msg.mapper.MsgMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class Msgimpl implements MsgService {
    @Resource
  private   MsgMapper msgMapper;

    public MsgMapper getMsgMapper() {
        return msgMapper;
    }

    public void setMsgMapper(MsgMapper msgMapper) {
        this.msgMapper = msgMapper;
    }





    @Override
    public List<Msg> show() {

        return msgMapper.selectByExample(null);
    }

    @Override
    public void saveMsg(Msg msg) {
        System.out.println("来了2"+msg);
        msgMapper.insertSelective(msg);
    }
}
