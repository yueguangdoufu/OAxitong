package com.rimi.ls.oa.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  公共dao的操作
 */
public class BaseDao<T> {

    public int insert(String sql,Object... param) {
        Connection connection = JDBUtil.getConnection();
        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            // 设置参数
            for (int i = 0; i < param.length; i++) {
                statement.setObject(i+1,param[i]);
            }
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBUtil.close();
        }
        return result;
    }
    public int update(String sql,Object... param){
        return insert(sql, param);
    }

    public int delete(String sql,Object... param) {
            return insert(sql, param);
    }

    public List<T> selectAll(String sql,Class<T> tClass,Object...param){
        List<T> list = new ArrayList<T>();
        try {
            Connection connection = JDBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                preparedStatement.setObject(i+1,param[i]);
            }
            // 获得结果集
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = preparedStatement.getMetaData();
            while (resultSet.next()){
                T t = tClass.newInstance();//获得实例对象
                int columnCount = metaData.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    // 获得每一列的名称
                    String name = metaData.getColumnName(i + 1);
                    // 获取每一列的结果
                    Object object = resultSet.getObject(name);
                    // 把结果存入到对象中
                    try {
                        BeanUtils .setProperty(t,name,object);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                list.add(t);//把数据添加到集合中
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }finally {
            JDBUtil.close();
        }

        return list;
    }
}
