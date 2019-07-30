package com.rimi.ls.oa.service.impl;

import com.rimi.ls.oa.dao.RoleDao;
import com.rimi.ls.oa.pojo.Role;

import java.util.List;

public class RoleServiceImpl  {
    // 声明RoleDao 类
    private RoleDao dao=new RoleDao();

    public List<Role> findAll() {
        String sql = "select * from t_Role";
        List<Role> RoleList = dao.selectAll(sql, Role.class);
        return RoleList;
    }


    public boolean deleteRoleById(int id) {
        //编写sql语句
        String sql="delete from t_Role where id= ?";
        //调用封装好的方法  执行sql语句 获取到影响行数
        int  result=dao.delete(sql,id);
        // 判断影响行数是否 大于 0
        if(result>0){
            return true;
        }
        return false;
    }

    public boolean updateRole(Role Role) {

        String sql="update t_Role set name=?,remark=? where id =?";
        String[] params={Role.getName(),Role.getRemark(),Role.getId()+""};
        int result=dao.update(sql,params);
        if(result>0){
            return true;
        }
        return false;
    }

    public boolean saveRole(Role Role) {
        String sql="insert into t_Role value(0,?,?)";
        String[] params={Role.getName(),Role.getRemark()};
        int result=dao.insert(sql,params);
        if(result>0){
            return true;
        }
        return false;
    }
}
