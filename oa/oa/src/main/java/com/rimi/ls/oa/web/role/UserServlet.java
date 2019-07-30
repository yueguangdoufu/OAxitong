package com.rimi.ls.oa.web.role;

import com.alibaba.fastjson.JSONObject;
import com.rimi.ls.oa.pojo.ResponsePojo;
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
import java.util.List;

@WebServlet(value = "/page/role/list")
public class UserServlet extends HttpServlet {

    //
    private RoleServiceImpl userService=new RoleServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 查询数据库获取到用户列表
        List<Role> data=userService.findAll();
        //响应对象
        ResponsePojo responsePojo=new ResponsePojo();
        //设置响应属性
        responsePojo.setData(data);
        //总数据
        responsePojo.setCount(data.size());
        //将响应参数的对象转换为json字符串
        String json=JSONObject.toJSONString(responsePojo);
        //将数据响应出去
        //设置编码
        response.setCharacterEncoding("utf-8");
        //获取一个输出对象
        PrintWriter writer = response.getWriter();
        // 将数据写出
        writer.write(json);
        //刷新
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
