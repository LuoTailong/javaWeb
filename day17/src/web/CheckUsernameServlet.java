package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        username = new String(username.getBytes("iso-8859-1"),("utf-8"));
        System.out.println(username);

        response.setContentType("text/html;charset=utf-8");
        //null是没有地址,length是有地址但是长度为0
        if (username == null || username.length() == 0||"zhangsan".equals(username)) {
            response.getWriter().println("<font color='red'>该账号不可用</font>");
        } else {
            response.getWriter().println("<font color='green'>该账号可用</font>");
        }
    }
}
