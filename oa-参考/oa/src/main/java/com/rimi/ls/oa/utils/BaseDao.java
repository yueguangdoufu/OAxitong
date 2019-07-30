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
        Connection connection = DBUtil.getConnection();
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
        } finally {
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
    public List<T> selectAll(String sql,Class<T> tClass)  {
        List<T> list = new ArrayList<>();

        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
    //                Field field = tClass.getDeclaredField(name);//获得字段
    //                field.setAccessible(true);
    //                field.set(t,object);
                    try {
                        BeanUtils.setProperty(t,name,object);
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
        } finally {
            DBUtil.close();
        }

        return list;
    }
}
