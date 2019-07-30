package com.rimi.ls.oa.web.news;

import com.alibaba.fastjson.JSONObject;
import com.rimi.ls.oa.pojo.News;
import com.rimi.ls.oa.pojo.ResponsePojo;
import com.rimi.ls.oa.service.INewService;
import com.rimi.ls.oa.service.impl.NewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/newList")
public class NewServlet extends HttpServlet {

    private INewService newService = new NewService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> data = newService.findAll();
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
