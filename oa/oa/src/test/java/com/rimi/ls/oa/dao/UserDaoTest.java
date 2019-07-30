package com.rimi.ls.oa.dao;

import com.rimi.ls.oa.pojo.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {

    private UserDao dao;

    @Before
    public void init() {
        dao = new UserDao();
    }

    @Test
    public void inset() throws SQLException {
        String sql = "insert into t_user(name,sex,address,telephone) values(?,?,?,?)";
        int i = dao.insert(sql, "shangzf", 1, "乐山师范学院贞松楼203", "18602885621");
        Assert.assertEquals(1, i);
    }

    @Test
    public void selectAll() {
        String sql = "select * from t_user";
        List<User> userList = dao.selectAll(sql, User.class);
        Assert.assertEquals(0, userList.size());

    }

}