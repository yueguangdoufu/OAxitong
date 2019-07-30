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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "NewAddServlet",urlPatterns = "/newAdd")
public class NewAddServlet extends HttpServlet {

    private INewService newService=new NewService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //获取用户输入的数据
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String up_time = df.format(new Date());
        //将参数封装成对象
        News news = new News();
        //将参数赋值进对象
        news.setTitle(title);
        if(content!=null&&!"".equals(content)){
            news.setContent(content);
        }
        news.setUp_time(up_time);
        //是否添加成功
        boolean isok=newService.insertNew(news);
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
