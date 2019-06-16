package servletConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ServletConfig1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int size = 500;
        response.setContentType("text/html;charset=utf-8");
        ServletConfig sc = this.getServletConfig();
        String str = sc.getInitParameter("size");
        int size = Integer.parseInt(str);
        response.getWriter().write("我生产的可乐是"+size+"毫升"+new Date().toString());
        /*
        开发原则:对修改关闭,对扩展开放
        */
    }
}
