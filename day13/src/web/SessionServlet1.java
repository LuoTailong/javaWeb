package web;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

public class SessionServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession hs = request.getSession();
        hs.setAttribute("ip", request.getRemoteAddr());

        /*
            遇到的问题: 浏览器关闭, session对象就消失了.
            原因: 因为session容器的id是以cookie的形式存在, 浏览器中. 当浏览器会话结束的时候, cookie就消失了
                 cookie消失就意味着JSESSIONID没有了, session容器就销毁了.
            解决方案:
                 延长 存储JSESSIONID的那个cookie的 最大生存时间.
            核心:
                如何保证Cookie的唯一性?     路径, name名.
         */

        Cookie cookie = new Cookie("JSESSIONID", hs.getId());
        cookie.setPath(request.getContextPath());
        cookie.setMaxAge(60 * 60 * 24 * 90);
        response.addCookie(cookie);


        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("SessionServlet1: IP存储成功..."+new Date().toLocaleString());
    }
}
