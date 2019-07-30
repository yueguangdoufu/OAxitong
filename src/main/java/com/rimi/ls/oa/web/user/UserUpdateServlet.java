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

@WebServlet(name = "UserUpdateServlet",urlPatterns = "/userUpdate")
public class UserUpdateServlet extends HttpServlet {

    private IUserService userService= new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 输出流
        PrintWriter writer = response.getWriter();
        //修改条件ID
        String id=request.getParameter("id");
        //获取所有的参数，包括修改和未修改的内容
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String qq = request.getParameter("qq");
        String telephone = request.getParameter("telephone");
        //将参数封装成对象
        User user=new User();
        //将Id存入对象
        if(id!=null&&!"".equals(id)){
            user.setId(Long.parseLong(id));
            System.out.println(user.getId());
        }
        //将参数赋值进对象
        user.setName(username);
        if(sex!=null&&!"".equals(sex)){
            user.setSex(Byte.decode(sex));
        }
        user.setTelephone(telephone);
        //调用service方法
        boolean isok=userService.updateUser(user);
        //判断是否修改成功
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
