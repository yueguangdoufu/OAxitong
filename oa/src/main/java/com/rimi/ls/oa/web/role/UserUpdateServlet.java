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
@WebServlet(value = "/page/role/update")
public class UserUpdateServlet extends HttpServlet {

    private RoleServiceImpl userService=new RoleServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 输出流
        PrintWriter writer = response.getWriter();
        //修改条件ID
        String id=request.getParameter("id");
        //获取所有的参数，包括修改和未修改的内容
        String username = request.getParameter("username");
        String remark = request.getParameter("telephone");
        //将参数封装成对象
        Role user=new Role();
        //将Id存入对象
        if(id!=null&&!"".equals(id)){
            user.setId(Long.parseLong(id));
            System.out.println(user.getId());
        }
        //将参数赋值进对象
        user.setName(username);
        user.setRemark(remark);
        //调用service方法
        boolean isok=userService.updateRole(user);
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
