package com.rimi.ls.oa.web.notice;

import com.rimi.ls.oa.pojo.Notice;
import com.rimi.ls.oa.service.INoticeService;
import com.rimi.ls.oa.service.impl.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NoticeUpdateServlet",urlPatterns = "/noticeUpdate")
public class NoticeUpdateServlet extends HttpServlet {

    private INoticeService noticeService= new NoticeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 输出流
        PrintWriter writer = response.getWriter();
        //修改条件ID
        String id=request.getParameter("nid");
        //获取所有的参数，包括修改和未修改的内容
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String name = request.getParameter("name");
        String up_time = request.getParameter("up_time");
        String important = request.getParameter("important");
        //将参数封装成对象
        Notice notice = new Notice();
        //将Id存入对象
        if(id!=null&&!"".equals(id)){
            notice.setId(Long.parseLong(id));
            System.out.println(notice.getId());
        }
        //将参数赋值进对象
        notice.setTitle(title);
        if(content!=null&&!"".equals(content)){
            notice.setContent(content);
        }
        notice.setName(name);
        notice.setUp_time(up_time);
        notice.setImportant(Byte.decode(important));
        //调用service方法
        boolean isok=noticeService.updateNotice(notice);
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
