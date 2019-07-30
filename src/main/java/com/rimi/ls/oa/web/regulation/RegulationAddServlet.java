package com.rimi.ls.oa.web.regulation;

import com.rimi.ls.oa.pojo.Regulation;
import com.rimi.ls.oa.pojo.User;
import com.rimi.ls.oa.service.IRegulationService;
import com.rimi.ls.oa.service.IUserService;
import com.rimi.ls.oa.service.impl.RegulationService;
import com.rimi.ls.oa.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegulationAddServlet",urlPatterns = "/regulationAdd")
public class RegulationAddServlet extends HttpServlet {

    private IRegulationService regulationService=new RegulationService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户输入的数据
        String file = request.getParameter("file2");
        //将参数封装成对象
        Regulation regulation = new Regulation();
        //将参数赋值进对象
        if(file!=null&&!"".equals(file)){
            regulation.setFile(file);
        }
        //是否添加成功
        boolean isok=regulationService.insertRegulation(regulation);
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
