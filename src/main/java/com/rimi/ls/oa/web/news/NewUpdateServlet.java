package com.rimi.ls.oa.web.news;

import com.rimi.ls.oa.pojo.News;
import com.rimi.ls.oa.pojo.User;
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

@WebServlet(name = "NewUpdateServlet",urlPatterns = "/newUpdate")
public class NewUpdateServlet extends HttpServlet {

    private INewService newService= new NewService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 输出流
        PrintWriter writer = response.getWriter();
        //修改条件ID
        String id=request.getParameter("nid");
        //获取所有的参数，包括修改和未修改的内容
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String up_time = request.getParameter("up_time");
        //将参数封装成对象
        News news = new News();
        //将Id存入对象
        if(id!=null&&!"".equals(id)){
            news.setId(Long.parseLong(id));
            System.out.println(news.getId());
        }
        //将参数赋值进对象
        news.setTitle(title);
        if(content!=null&&!"".equals(content)){
            news.setContent(content);
        }
        news.setUp_time(up_time);
        //调用service方法
        boolean isok=newService.updateNew(news);
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
