package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletContext4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext域的引用
        ServletContext sc = getServletContext();
        //从其中获取IP
        String ip = (String) sc.getAttribute("ip");
        //把获取到的ip属性响应给页面
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("我是ServletContext4,我获取到的IP是:"+ip);
    }
}
