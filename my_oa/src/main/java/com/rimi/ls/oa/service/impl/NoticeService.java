package com.rimi.ls.oa.service.impl;

import com.rimi.ls.oa.dao.NoticeDao;
import com.rimi.ls.oa.pojo.Notice;
import com.rimi.ls.oa.service.INoticeService;

import java.util.List;

public class NoticeService implements INoticeService {

    private NoticeDao dao;

    public NoticeService() {
        this.dao = new NoticeDao();
    }

    @Override
    public List<Notice> findAll() {
        String sql = "select * from notice";
        List<Notice> noticeList = dao.selectAll(sql, Notice.class);
        return noticeList;
    }


    @Override
    public boolean deleteNoticeById(int id) {
        String sql="delete from notice where id=?";
        int delete = dao.delete(sql, id);
        if(delete>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertNotice(Notice notice) {
        String sql="insert into notice(title,content,name,up_time,important) value(?,?,?,?,?)";
        String[] param={notice.getTitle(),notice.getContent(),notice.getName(),notice.getUp_time(),notice.getImportant()+""};
        int insert = dao.insert(sql, param);
        if(insert>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateNotice(Notice notice) {
        String sql="update notice set title=?,content?,name=?,up_time=?,important=? where id=?";
        String[] param={notice.getTitle(),notice.getContent(),notice.getName(),notice.getUp_time(),notice.getImportant()+"",notice.getId()+""};
        int update = dao.update(sql, param);
        if(update>0){
            return true;
        }

        return false;
    }
}
