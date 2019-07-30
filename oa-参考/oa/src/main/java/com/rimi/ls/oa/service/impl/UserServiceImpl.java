package com.rimi.ls.oa.service.impl;

import com.rimi.ls.oa.dao.UserDao;
import com.rimi.ls.oa.pojo.User;
import com.rimi.ls.oa.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {

    private UserDao dao;

    public UserServiceImpl() {
        this.dao = new UserDao();
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from t_user";
        List<User> userList = dao.selectAll(sql, User.class);
        return userList;
    }
}
