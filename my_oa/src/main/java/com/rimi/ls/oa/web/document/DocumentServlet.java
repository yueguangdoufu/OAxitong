package com.rimi.ls.oa.web.document;

import com.alibaba.fastjson.JSONObject;
import com.rimi.ls.oa.pojo.Document;
import com.rimi.ls.oa.pojo.ResponsePojo;
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
import java.util.List;

@WebServlet(name = "DocumentServlet",urlPatterns = "/documentList")
public class DocumentServlet extends HttpServlet {

    private IDocumentService documentService = new DocumentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Document> data = documentService.findAll();
        ResponsePojo responsePojo = new ResponsePojo();
        responsePojo.setData(data);
        responsePojo.setMsg("hei");
        responsePojo.setCount(data.size());

        String json = JSONObject.toJSONString(responsePojo);
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write(json);
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
