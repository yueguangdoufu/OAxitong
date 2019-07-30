package com.rimi.ls.oa.service;

import com.rimi.ls.oa.pojo.User;

import java.util.List;

public interface IUserService {
    //查询所有用户数量
    public int  findAllCount();
    //查询某一页的用户
    List<User> findAll(String page,String limit);

    //登录方法
    User  login(String userName,String userPs);
    // 根据id 删除用户
    boolean  deleteUserById(int id);
    //修改用户信息  根据用户的编号id 进行修改
    boolean  updateUser(User user);
    //添加用户
    boolean saveUser(User user);
}
