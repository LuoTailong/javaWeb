package web;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);//不用new User写法:BeanUtils.populate(User.class, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UserService us = new UserService();
        User loginUser = us.isLogin(user);
        if (loginUser != null) {
            request.getSession().setAttribute("loginUser", loginUser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        } else {
            request.setAttribute("message", "用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
