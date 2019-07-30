package com.rimi.ls.oa.web.document;

import com.rimi.ls.oa.pojo.Document;
import com.rimi.ls.oa.pojo.User;
import com.rimi.ls.oa.service.IDocumentService;
import com.rimi.ls.oa.service.IUserService;
import com.rimi.ls.oa.service.impl.DocumentService;
import com.rimi.ls.oa.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DocumentUpdateServlet",urlPatterns = "/documentUpdate")
public class DocumentUpdateServlet extends HttpServlet {

    private IDocumentService documentService= new DocumentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 输出流
        PrintWriter writer = response.getWriter();
        //修改条件ID
        String id=request.getParameter("did");
        //获取所有的参数，包括修改和未修改的内容
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String file = request.getParameter("file");
        String up_time = request.getParameter("up_time");
        //将参数封装成对象
        Document document = new Document();
        //将Id存入对象
        if(id!=null&&!"".equals(id)){
            document.setId(Long.parseLong(id));
            System.out.println(document.getId());
        }
        //将参数赋值进对象
        document.setName(name);
        if(content!=null&&!"".equals(content)){
            document.setContent(content);
        }
        document.setTitle(title);
        document.setFile(file);
        document.setUp_time(up_time);
        //调用service方法
        boolean isok=documentService.updateDocument(document);
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
