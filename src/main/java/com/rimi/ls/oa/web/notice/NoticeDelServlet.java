package com.rimi.ls.oa.web.notice;

import com.rimi.ls.oa.service.INoticeService;
import com.rimi.ls.oa.service.impl.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NoticeDelServlet",urlPatterns = "/noticeDel")
public class NoticeDelServlet extends HttpServlet {

    private INoticeService noticeService=new NoticeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();

        String id = request.getParameter("id");
        if(id!=null&&!"".equals(id)){
            int i = Integer.parseInt(id);
            boolean result = noticeService.deleteNoticeById(i);
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
