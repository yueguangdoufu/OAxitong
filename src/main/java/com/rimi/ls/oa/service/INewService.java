package com.rimi.ls.oa.service;

import com.rimi.ls.oa.pojo.News;

import java.util.List;

public interface INewService {

    //查询所有用户
    List<News> findAll();

    //删除用户
    boolean deleteNewById(int id);
    //插入用户
    boolean insertNew(News news);
    //修改用户
    boolean updateNew(News news);

}
