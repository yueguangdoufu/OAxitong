package com.rimi.ls.oa.service.impl;

import com.rimi.ls.oa.dao.UserDao;
import com.rimi.ls.oa.pojo.User;
import com.rimi.ls.oa.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    // 声明UserDao 类
    private UserDao dao;

    public UserServiceImpl() {
        this.dao = new UserDao();
    }

    public int  findAllCount(){
        String sql="select * from t_user";
        List<User> userList = dao.selectAll(sql, User.class);
        return userList.size();
    }

    @Override
    public List<User> findAll(String page,String limit) {
        //（要显示的页数-1） * 每页要显示的条数  获取到 起始行数
        int start=(Integer.parseInt(page)-1)*Integer.parseInt(limit);
        //分页的语句
        String sql = "select * from t_user limit "+start+","+limit;
        List<User> userList = dao.selectAll(sql, User.class);
        return userList;
    }

    @Override
    public User login(String userName, String userPs) {
        //sql语句   ? 占位符
        String sql="select *  from t_user where name=?  and  password = ?";
        // ？ 对应的参数
        String[] params={userName,userPs}; //参数顺序 一定要与 ？ 位置保持一致
        // 调用dao方法 查询数据库
        List<User> list=dao.selectAll(sql,User.class,params);
        //集合是否为空   如果不为空 则将集合中第一个对象返回
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        //集合为空 返回null
        return null;
    }

    @Override
    public boolean deleteUserById(int id) {
        //编写sql语句
        String sql="delete from t_user where id= ?";
        //调用封装好的方法  执行sql语句 获取到影响行数
        int  result=dao.delete(sql,id);
        // 判断影响行数是否 大于 0
        if(result>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {

        String sql="update t_user set name=?,password=?,sex=?,address=?,telephone=? where id =?";
        String[] params={user.getName(),user.getPassword(),user.getSex()+"",user.getAddress(),user.getTelephone(),user.getId()+""};
        int result=dao.update(sql,params);
        if(result>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean saveUser(User user) {
        String sql="insert into t_user(name,password,sex,address,telephone) value(?,?,?,?,?)";
        String[] params={user.getName(),user.getPassword(),user.getSex()+"",user.getAddress(),user.getTelephone()};
        int result=dao.insert(sql,params);
        if(result>0){
            return true;
        }
        return false;
    }
}
