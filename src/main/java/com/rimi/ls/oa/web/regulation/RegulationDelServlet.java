package com.rimi.ls.oa.web.regulation;

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

@WebServlet(name = "RegulationDelServlet",urlPatterns = "/regulationDel")
public class RegulationDelServlet extends HttpServlet {

    private IRegulationService regulationService=new RegulationService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();

        String id = request.getParameter("id");
        if(id!=null&&!"".equals(id)){
            int i = Integer.parseInt(id);
            boolean result = regulationService.deleteRegulationById(i);
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
