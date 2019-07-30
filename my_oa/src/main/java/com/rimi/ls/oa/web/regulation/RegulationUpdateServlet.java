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

@WebServlet(name = "RegulationUpdateServlet",urlPatterns = "/regulationUpdate")
public class RegulationUpdateServlet extends HttpServlet {

    private IRegulationService regulationService= new RegulationService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 输出流
        PrintWriter writer = response.getWriter();
        //修改条件ID
        String id=request.getParameter("rid");
        //获取所有的参数，包括修改和未修改的内容
        String file = request.getParameter("file");
        //将参数封装成对象
        Regulation regulation = new Regulation();
        //将Id存入对象
        if(id!=null&&!"".equals(id)){
            regulation.setId(Long.parseLong(id));
            System.out.println(regulation.getId());
        }
        //将参数赋值进对象
        if(file!=null&&!"".equals(file)){
            regulation.setFile(file);
        }
        //调用service方法
        boolean isok=regulationService.updateRegulation(regulation);
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
