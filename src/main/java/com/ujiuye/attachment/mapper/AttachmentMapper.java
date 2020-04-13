package com.ujiuye.attachment.mapper;

import com.ujiuye.attachment.bean.AttExtend;
import com.ujiuye.attachment.bean.Attachment;
import com.ujiuye.attachment.bean.AttachmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttachmentMapper {
    int countByExample(AttachmentExample example);

    int deleteByExample(AttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    List<Attachment> selectByExample(AttachmentExample example);

    Attachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Attachment record, @Param("example") AttachmentExample example);

    int updateByExample(@Param("record") Attachment record, @Param("example") AttachmentExample example);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKey(Attachment record);

    List<AttExtend> show();
}