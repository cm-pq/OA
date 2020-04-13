package com.ujiuye.attachment.service;

import com.ujiuye.attachment.bean.AttExtend;
import com.ujiuye.attachment.bean.Attachment;

import java.util.List;

public interface AttService {
    List<AttExtend> show();

    void add(Attachment attachment);
}
