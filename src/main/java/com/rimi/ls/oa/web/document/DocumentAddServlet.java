package com.rimi.ls.oa.web.document;

import com.rimi.ls.oa.pojo.Document;
import com.rimi.ls.oa.service.IDocumentService;
import com.rimi.ls.oa.service.impl.DocumentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "DocumentAddServlet",urlPatterns = "/documentAdd")
public class DocumentAddServlet extends HttpServlet {

    private IDocumentService documentService=new DocumentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取用户输入的数据
        String username = request.getParameter("name");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String file = request.getParameter("file2");
      System.out.println(file);
        String up_time = df.format(new Date());
        //将参数封装成对象
        Document document = new Document();
        //将参数赋值进对象
        document.setName(username);
        if(content!=null&&!"".equals(content)){
            document.setContent(content);
        }
        document.setContent(content);
        document.setTitle(title);
        document.setUp_time(up_time);
        document.setFile(file);
        //是否添加成功
        boolean isok=documentService.insertDocument(document);
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
