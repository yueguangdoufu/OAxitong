package com.rimi.ls.oa.web.system;

import com.alibaba.fastjson.JSONObject;
import com.rimi.ls.oa.pojo.User;
import com.rimi.ls.oa.service.IUserService;
import com.rimi.ls.oa.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private IUserService userService=new UserServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取登陆的参数
        String username = request.getParameter("username");//用户名
        String password = request.getParameter("password");//密码
        //将参数以json格式的字符串 返回
        JSONObject jsonObject = new JSONObject();
        //用户信息存储在数据库中
        //查询数据库 判断改用户是否存在
        User user =userService.login(username,password);
        //存在: 可以登录
        //并将当前用户的信息存储到 会话中
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        //不存在： 登录失败提示信息
        if (user!=null){ //登录成功
            jsonObject.put("code",200);
        } else {
            jsonObject.put("code",201);
            jsonObject.put("msg","用户名或密码错误");
        }
        System.out.println(jsonObject.toJSONString()+"-----------");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        //获取输出流
        PrintWriter writer = response.getWriter();
        writer.print(jsonObject.toJSONString());//返回json数据
        writer.flush();//刷新
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
