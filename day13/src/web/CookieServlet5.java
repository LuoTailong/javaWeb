package web;

import utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CookieServlet5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = CookieUtils.getCookieName(cookies, "lastVisit");
        response.setContentType("text/html;charset=utf-8");
        if (cookie != null) {
            response.getWriter().println("您最后一次访问的时间是: "+cookie.getValue());
        } else {
            response.getWriter().println("欢迎登陆本网站");
        }

        cookie = new Cookie("lastVisit", new Date().toLocaleString());
        cookie.setMaxAge(60 *60 *24 *90);

        response.addCookie(cookie);
    }
}
