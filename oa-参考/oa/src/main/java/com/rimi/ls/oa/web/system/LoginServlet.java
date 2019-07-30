package com.rimi.ls.oa.web.system;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到登陆的方法中了===========================");
        // 获取登陆的参数
        String username = request.getParameter("username");//用户名
        String password = request.getParameter("password");//密码
        System.out.println("用户名："+username);
        System.out.println("密码："+password);

        JSONObject jsonObject = new JSONObject();
        if ("admin".equals(username) && "123".equals(password)){
            jsonObject.put("code",200);
        } else {
            jsonObject.put("code",201);
            jsonObject.put("msg","用户名或密码错误");
        }
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(jsonObject.toJSONString());//返回json数据
        writer.flush();//刷新
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
