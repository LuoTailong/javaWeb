package web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CookieServlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //cookie的唯一性依赖: 路径, 名字.
        Cookie cookie = new Cookie("username", "");
        cookie.setPath(request.getContextPath()+"/car");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("CookieServlet4: cookie对象删除成功"+new Date().toString());
    }
}
