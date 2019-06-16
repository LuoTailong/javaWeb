package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletContext3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //把IP地址放到ServletContext域容器中
        //由Servlet4来读取该IP地址

        //1.获取访问时的IP
        String ip = request.getRemoteAddr();

        //2.把ip设置到ServletContext域容器中
        //获取ServletContext容器的:引用
        ServletContext sc = getServletContext();
        sc.setAttribute("ip", ip);

        //3.给浏览器响应一句话
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("我是ServleContext3, 我把IP"+ip+"放进域容器中了");
    }
}
