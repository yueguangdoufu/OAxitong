package com.rimi.ls.oa.web.system;

import com.alibaba.fastjson.JSONObject;
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

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private IUserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到登陆的方法中了=======");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("用户名:"+username);
        System.out.println("密码:"+password);
        request.setCharacterEncoding("UTF-8");
        JSONObject jsonObject = new JSONObject();

        User user = userService.login(username,password);
        //存在: 可以登录
        //不存在： 登录失败提示信息
        if (user!=null){ //登录成功
            jsonObject.put("code",200);
        } else {
            jsonObject.put("code",201);
            jsonObject.put("msg","用户名或密码错误");
        }
        PrintWriter writer = response.getWriter();
        writer.print(jsonObject.toJSONString());
        writer.flush();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
