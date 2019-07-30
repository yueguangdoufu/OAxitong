package com.rimi.ls.oa.utils;

import sun.dc.pr.PRError;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库操作工具类
 */
public class DBUtil {

    private static final String DB_URL="jdbc:mysql://localhost:3306/oa";//数据库连接地址
    private static final String DB_USERNAME="root";
    private static final String DB_PASSWORD="12345";
    private static Connection connection;

    //定义静态代码块，用于初始化数据库连接
    static {

            // 加载驱动
            // 获取连接
        try {
            Class.forName("com.mysql.jdbc.Driver");// 反射
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获得数据库连接
     * @return
     */
    public static Connection getConnection(){
        return connection;
    }

    /**
     * 关闭连接
     */
    public static void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
