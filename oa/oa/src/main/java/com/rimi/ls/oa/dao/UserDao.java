package com.rimi.ls.oa.dao;

import com.rimi.ls.oa.pojo.User;
import com.rimi.ls.oa.utils.BaseDao;
import com.rimi.ls.oa.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户数据操作类
 */
public class UserDao extends BaseDao<User> {

//    /**
//     * 查询操作
//     */
//    public List<User> select(){
//        List<User> userList = new ArrayList<>();
//        Connection connection = DBUtil.getConnection();
//        String sql = "select * form t_user";
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()){
//                Long id = resultSet.getLong("id");
//                String name = resultSet.getString("name");
//                Byte sex = resultSet.getByte("sex");
//                String address = resultSet.getString("address");
//                String telephone = resultSet.getString("telephone");
//                User user = new User(id,name,sex,address,telephone);
//                userList.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return userList;
//    }

}
