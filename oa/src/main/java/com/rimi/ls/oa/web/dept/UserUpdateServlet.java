package com.rimi.ls.oa.web.dept;

import com.rimi.ls.oa.pojo.Department;
import com.rimi.ls.oa.pojo.User;
import com.rimi.ls.oa.service.IUserService;
import com.rimi.ls.oa.service.impl.DeptServiceImpl;
import com.rimi.ls.oa.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: Jerry
 * @Date: 2018/6/7/007 14:43
 * @Description:
 */
@WebServlet(value = "/page/dept/update")
public class UserUpdateServlet extends HttpServlet {

    private DeptServiceImpl userService=new DeptServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 输出流
        PrintWriter writer = response.getWriter();
        //修改条件ID
        String id=request.getParameter("id");
        //获取所有的参数，包括修改和未修改的内容
        String username = request.getParameter("name");
        String depNum = request.getParameter("departNum");
        String remark = request.getParameter("remark");
        //将参数封装成对象
        Department user=new Department();
        //将Id存入对象
        if(id!=null&&!"".equals(id)){
            user.setId(Long.parseLong(id));
            System.out.println(user.getId());
        }
        //将参数赋值进对象
        user.setName(username);
        user.setDepartNum(depNum);
        user.setRemark(remark);
        //调用service方法
        boolean isok=userService.updateDepartment(user);
        //判断是否修改成功
        if(isok){
            writer.print(200);
        }else{
            writer.print(500);
        }
        writer.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
