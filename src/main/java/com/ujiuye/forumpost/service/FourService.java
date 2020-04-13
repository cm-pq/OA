package com.ujiuye.forumpost.service;

import com.ujiuye.forumpost.bean.ForumExtend;
import com.ujiuye.forumpost.bean.Forumpost;

import java.util.List;

public interface FourService {
    List<Forumpost> show();

    void add(Forumpost forumpost);

    ForumExtend look(Integer id);
}
