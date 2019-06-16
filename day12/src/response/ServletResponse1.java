package response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletResponse1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //方式一:
        //ServletResponse1告诉浏览器, 我没有这个资源.  写一个状态码: 302
        response.setStatus(302);

        //response.setHeader("location","/项目名/新的servlet名");
        response.setHeader("location", "/day12/servletResponse2");

        //方式二:
//        response.sendRedirect("/day12/servletResponse2");

//        response.sendRedirect("http://www.itheima.com");

        /*
            重定向与请求转发的区别?
            1.几次转发, 几次相应?
              重定向:n次转发, n次响应
              请求转发:1次转发, 1次响应
            2.访问资源(窗体内容)和URL地址栏中显示的路径是否一致?
              重定向:一致
              请求转发:不一致
            3.关于API的写法, 要不要写项目名?
              重定向:写
              请求转发:不写
            4.关于页面能不能跳转到外部路径
              重定向:既可以是外部的也可以是内部的
              请求转发:不可以
            5.如果把request作为域容器使用, 哪种方式更合适?
              重定向:不合适
              请求转发:合适
              跳转以后request对象依旧使用的话用请求转发, 其余情况看心情

        */
    }
}
