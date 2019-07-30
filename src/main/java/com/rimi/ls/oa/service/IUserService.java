package com.rimi.ls.oa.service;

import com.rimi.ls.oa.pojo.Notice;
import com.rimi.ls.oa.pojo.User;

import java.util.List;

public interface IUserService {

    //查询所有用户
    List<User> findAll();

    //登录方法
    User  login(String userName,String userPs);

    //删除用户
    boolean deleteUserById(int id);
    //插入用户
    boolean insertUser(User user);
    //修改用户
    boolean updateUser(User user);
}
