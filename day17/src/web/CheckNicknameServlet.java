package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckNicknameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=utf-8");
        String nickname = request.getParameter("nickname");

        if (nickname == null || nickname.length() == 0||"zhangsan".equals(nickname)) {
            response.getWriter().println("<font color='red'>该昵称不可用</font>");
        } else {
            response.getWriter().println("<font color='green'>该昵称可用</font>");
        }
    }
}
