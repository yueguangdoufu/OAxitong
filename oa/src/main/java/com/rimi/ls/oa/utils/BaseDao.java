package com.rimi.ls.oa.utils;

import org.apache.commons.beanutils.BeanUtils;
import sun.security.pkcs11.Secmod;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  公共dao的操作
 */
public class BaseDao<T> {

    public int insert(String sql,Object... param)  {
        //获取链接
        Connection connection = DBUtil.getConnection();
        //影响行数
        int result = 0;
        try {
            //创建与状态通道
            PreparedStatement statement = connection.prepareStatement(sql);
            // 设置参数   绑定参数  给？赋值
            for (int i = 0; i < param.length; i++) {
                statement.setObject(i+1,param[i]);
            }
            //执行sql语句  并获取到该sql语句影响的行数
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
           DBUtil.close();
        }
        return result;
    }
    public int update(String sql,Object... param) {
        return insert(sql, param);
    }
    public int delete(String sql,Object... param)  {
        return insert(sql, param);
    }
    //                  不完整的sql语句  你要查询对象的类型  ？对应的参数的数组  可以传0到多个参数
    public List<T> selectAll(String sql,Class<T> tClass,Object... param)  {
        //创建数组
        List<T> list = new ArrayList<>();
        try {
            //通过工具类 获取一个与数据库的链接
            Connection connection = DBUtil.getConnection();
            //通过连接创建一个预状态通道    就是一个执行sql语句的类
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //
            for (int i = 0; i < param.length; i++) {
                //绑定参数  给？赋值        ？的位置           具体？对应的值
                preparedStatement.setObject(i+1,param[i]);
            }
            // 执行sql语句得到查询的结果  获得结果集
            ResultSet resultSet = preparedStatement.executeQuery();
            //该对象中 包含查询的表中信息（字段、值）
            ResultSetMetaData metaData = preparedStatement.getMetaData();
            // 遍历结果集
            while (resultSet.next()){ // 判断集合中是否还有下一个值
                T t = tClass.newInstance();//获得实例对象 按照传递过来对象类型，创建该类型对象
                //获取查询结果的列的数量
                int columnCount = metaData.getColumnCount();
                // 按照列的总数量进行循环
                for (int i = 0; i < columnCount; i++) {
                    // 获得每一列的名称
                    String name = metaData.getColumnName(i + 1);
                    // 获取每一列的结果  根据列的名称得到该列对应的值
                    Object object = resultSet.getObject(name);
                    try {
                        //第一个参数:对象 、数据库中的列名（对象中的属性名）、查询的结果（值）
                        BeanUtils.setProperty(t,name,object);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                //将已经存在值的对象存储到集合中
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            DBUtil.close();
        }
        return list;
    }

    public T selectOne(String sql,Class<T> tClass,Object... param)  {
        try {
            //通过工具类 获取一个与数据库的链接
            Connection connection = DBUtil.getConnection();
            //通过连接创建一个预状态通道    就是一个执行sql语句的类
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //
            for (int i = 0; i < param.length; i++) {
                //绑定参数  给？赋值        ？的位置           具体？对应的值
                preparedStatement.setObject(i+1,param[i]);
            }
            // 执行sql语句得到查询的结果  获得结果集
            ResultSet resultSet = preparedStatement.executeQuery();
            //该对象中 包含查询的表中信息（字段、值）
            ResultSetMetaData metaData = preparedStatement.getMetaData();
            // 遍历结果集
            while (resultSet.next()){ // 判断集合中是否还有下一个值
                T t = tClass.newInstance();//获得实例对象 按照传递过来对象类型，创建该类型对象
                //获取查询结果的列的数量
                int columnCount = metaData.getColumnCount();
                // 按照列的总数量进行循环
                for (int i = 0; i < columnCount; i++) {
                    // 获得每一列的名称
                    String name = metaData.getColumnName(i + 1);
                    // 获取每一列的结果  根据列的名称得到该列对应的值
                    Object object = resultSet.getObject(name);
                    try {
                        //第一个参数:对象 、数据库中的列名（对象中的属性名）、查询的结果（值）
                        BeanUtils.setProperty(t,name,object);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                return t;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            DBUtil.close();
        }
        return null;
    }
}
