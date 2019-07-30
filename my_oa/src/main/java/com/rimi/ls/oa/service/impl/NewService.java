package com.rimi.ls.oa.service.impl;

import com.rimi.ls.oa.dao.NewsDao;
import com.rimi.ls.oa.pojo.News;
import com.rimi.ls.oa.service.INewService;

import java.util.List;

public class NewService implements INewService {

    private NewsDao dao;

    public NewService() {
        this.dao = new NewsDao();
    }

    @Override
    public List<News> findAll() {
        String sql = "select * from news";
        List<News> userList = dao.selectAll(sql, News.class);
        return userList;
    }


    @Override
    public boolean deleteNewById(int id) {
        String sql="delete from news where id=?";
        int delete = dao.delete(sql, id);
        if(delete>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertNew(News news) {
        String sql="insert into news(title,content,up_time) value(?,?,?)";
        String[] param={news.getTitle(),news.getContent(),news.getUp_time()};
        int insert = dao.insert(sql, param);
        if(insert>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateNew(News news) {
        String sql="update news set title=?,content?,up_time=? where id=?";
        String[] param={news.getTitle(),news.getContent(),news.getUp_time()};
        int update = dao.update(sql, param);
        if(update>0){
            return true;
        }

        return false;
    }
}
