package com.rimi.ls.oa.web.news;

import com.rimi.ls.oa.service.INewService;
import com.rimi.ls.oa.service.IUserService;
import com.rimi.ls.oa.service.impl.NewService;
import com.rimi.ls.oa.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NewDelServlet",urlPatterns = "/newDel")
public class NewDelServlet extends HttpServlet {

    private INewService newService=new NewService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();

        String id = request.getParameter("id");
        if(id!=null&&!"".equals(id)){
            int i = Integer.parseInt(id);
            boolean result = newService.deleteNewById(i);
            if(result){
                writer.print(200);
            }else {
                writer.print(500);
            }
        }else {
            writer.print(500);
        }
        writer.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
