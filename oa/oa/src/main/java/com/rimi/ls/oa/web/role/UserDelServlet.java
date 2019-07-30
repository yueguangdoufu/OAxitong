package com.rimi.ls.oa.web.role;

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
@WebServlet(value = "/page/role/del")
public class UserDelServlet extends HttpServlet {

    private RoleServiceImpl userService=new RoleServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的编码
        response.setCharacterEncoding("utf-8");
        // 获取到输出流对象
        PrintWriter writer = response.getWriter();
        //接收到 要删除用户的ID 编号
        String id=request.getParameter("id");
        //将字符串类型id 转换为int  并且排除掉 null 以及 ""
        if(id!=null&&!"".equals(id)){
            int i=Integer.parseInt(id);
            //调用service写好的删除功能  获取到是否删除成功
            boolean result=userService.deleteRoleById(i);
            //判断该值是true 还是false 做出不同的响应 、提示
            if(result){ //删除成功
                writer.print(200);
            }else{//删除失败
                writer.print(500);
            }
        }else{ //参数不能为空
            writer.print(500);
        }
        //刷新
        writer.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
