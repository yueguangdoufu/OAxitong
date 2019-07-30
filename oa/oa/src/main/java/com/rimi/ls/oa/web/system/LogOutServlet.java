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

@WebServlet(value = "/page/user/logout")
public class LogOutServlet extends HttpServlet {

    private IUserService userService=new UserServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //销毁session
        session.invalidate();
        //用户信息存储在数据库中
        response.setCharacterEncoding("UTF-8");
        //设置响应类型
        response.setContentType("application/json");
        //获取输出流
        PrintWriter writer = response.getWriter();
        writer.print(0);//返回json数据
        writer.flush();//刷新
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
