package com.rimi.ls.oa.web.user;

import com.rimi.ls.oa.pojo.User;
import com.rimi.ls.oa.service.IUserService;
import com.rimi.ls.oa.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserAddServlet",urlPatterns = "/userAdd")
public class UserAddServlet extends HttpServlet {

    private IUserService userService=new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户输入的数据
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String qq = request.getParameter("qq");
        String telephone = request.getParameter("telephone");
        //将参数封装成对象
        User user=new User();
        //将参数赋值进对象
        user.setName(username);
        if(sex!=null&&!"".equals(sex)){
            user.setSex(Byte.decode(sex));
        }
        user.setTelephone(telephone);
        //是否添加成功
        boolean isok=userService.insertUser(user);
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
        this.doPost(request, response);
    }
}
