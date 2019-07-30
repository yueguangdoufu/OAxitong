package com.rimi.ls.oa.service.impl;

import com.rimi.ls.oa.dao.UserDao;
import com.rimi.ls.oa.pojo.User;
import com.rimi.ls.oa.service.IUserService;

import java.util.List;

public class UserService implements IUserService {

    private UserDao dao;

    public UserService() {
        this.dao = new UserDao();
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from t_user";
        List<User> userList = dao.selectAll(sql, User.class);
        return userList;
    }

    @Override
    public User login(String userName, String userPs) {
        //sql语句   ? 占位符
        String sql="select *  from t_user where name=?  and  password=?";
        String[] params={userName,userPs}; //参数顺序 一定要与 ？ 位置保持一致
        // 调用dao方法 查询数据库
        List<User> list=dao.selectAll(sql,User.class,params);
        //集合是否为空
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean deleteUserById(int id) {
        String sql="delete from t_user where id=?";
        int delete = dao.delete(sql, id);
        if(delete>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertUser(User user) {
        String sql="insert into t_user(name,sex,address,telephone,password) value(?,?,?,?,?)";
        String[] param={user.getName(),user.getSex()+"",user.getAddress(),user.getTelephone(),user.getPassword()};
        int insert = dao.insert(sql, param);
        if(insert>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        String sql="update t_user set name=?,sex=?,address=?,telephone=?,password=? where id=?";
        String[] param={user.getName(),user.getSex()+"",user.getAddress(),user.getTelephone(),user.getPassword(),user.getId()+""};
        int update = dao.update(sql, param);
        if(update>0){
            return true;
        }

        return false;
    }
}
