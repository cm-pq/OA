package com.ujiuye.attachment.service;

import com.ujiuye.attachment.bean.AttExtend;
import com.ujiuye.attachment.bean.Attachment;
import com.ujiuye.attachment.mapper.AttachmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class Attimpl  implements AttService {
    @Resource
   private AttachmentMapper attachmentMapper;
    @Override
    public List<AttExtend> show() {
      List<AttExtend> attExtends =  attachmentMapper.show();

        return attExtends;
    }

    @Override
    public void add(Attachment attachment) {
 attachmentMapper.insertSelective(attachment);
    }
}
