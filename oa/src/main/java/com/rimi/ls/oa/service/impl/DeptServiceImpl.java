package com.rimi.ls.oa.service.impl;

import com.rimi.ls.oa.dao.DeptDao;
import com.rimi.ls.oa.pojo.Department;

import java.util.List;

public class DeptServiceImpl  {
    // 声明DepartmentDao 类
    private DeptDao dao;

    public DeptServiceImpl() {
        this.dao = new DeptDao();
    }

    public List<Department> findAll() {
        String sql = "select * from t_dept";
        List<Department> DepartmentList = dao.selectAll(sql, Department.class);
        return DepartmentList;
    }


    public boolean deleteDepartmentById(int id) {
        //编写sql语句
        String sql="delete from t_dept where id= ?";
        //调用封装好的方法  执行sql语句 获取到影响行数
        int  result=dao.delete(sql,id);
        // 判断影响行数是否 大于 0
        if(result>0){
            return true;
        }
        return false;
    }

    public boolean updateDepartment(Department Department) {

        String sql="update t_dept set name=?,departNum=?,remark=? where id =?";
        String[] params={Department.getName(),Department.getDepartNum(),Department.getRemark(),Department.getId()+""};
        int result=dao.update(sql,params);
        if(result>0){
            return true;
        }
        return false;
    }

    public boolean saveDepartment(Department Department) {
        String sql="insert into t_dept value(0,?,?,?)";
        String[] params={Department.getName(),Department.getDepartNum(),Department.getRemark()+""};
        int result=dao.insert(sql,params);
        if(result>0){
            return true;
        }
        return false;
    }
}
