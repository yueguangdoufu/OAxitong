package com.rimi.ls.oa.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: Jerry
 * @Date: 2018/6/7/007 23:54
 * @Description:
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        //获取session会话中的用户
        Object user = request.getSession().getAttribute("user");
        //判断是否存在
        if (user!=null){
            //如果有则放行请求
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //没有 告诉浏览器  去跳转到登陆页面
            HttpServletResponse response=(HttpServletResponse)servletResponse;
            //
            response.sendRedirect("/");
        }
    }

    @Override
    public void destroy() {

    }
}
