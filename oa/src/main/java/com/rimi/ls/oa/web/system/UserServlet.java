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

@WebServlet(value = "/page/user/getNowUser")
public class UserServlet extends HttpServlet {

    private IUserService userService=new UserServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //将参数以json格式的字符串 返回
        JSONObject jsonObject = new JSONObject();
        //用户信息存储在数据库中
        if (user!=null){ //登录成功
            jsonObject.put("user",user);
            jsonObject.put("code",200);
        } else {
            jsonObject.put("code",500);
            jsonObject.put("msg","登录失效,请重新登录");
        }
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
