package web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CookieServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("username", "lisi");
        cookie.setMaxAge(60);
        cookie.setPath(request.getContextPath()+"/car");

        response.addCookie(cookie);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("CookieServlet1: cookie对象发送成功..."+new Date().toString());
    }
}
