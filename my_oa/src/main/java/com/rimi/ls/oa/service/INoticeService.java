package com.rimi.ls.oa.service;

import com.rimi.ls.oa.pojo.Notice;

import java.util.List;

public interface INoticeService {
    List<Notice> findAll();

    boolean deleteNoticeById(int id);
    boolean insertNotice(Notice notice);
    boolean updateNotice(Notice notice);
}
