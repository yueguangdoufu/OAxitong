package com.rimi.ls.oa.web.role;

import com.rimi.ls.oa.pojo.Role;
import com.rimi.ls.oa.pojo.User;
import com.rimi.ls.oa.service.IUserService;
import com.rimi.ls.oa.service.impl.RoleServiceImpl;
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
@WebServlet(value = "/page/role/add")
public class UserAddServlet extends HttpServlet {

    private RoleServiceImpl userService=new RoleServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户输入的数据
        String username = request.getParameter("username");
        String remark = request.getParameter("telephone");
        //将参数封装成对象
        Role user=new Role();
        //将参数赋值进对象
        user.setName(username);
        user.setRemark(remark);
        //是否添加成功
        boolean isok=userService.saveRole(user);
        //获取到输出流对象
        PrintWriter writer = response.getWriter();
        //判断是否添加成功
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
