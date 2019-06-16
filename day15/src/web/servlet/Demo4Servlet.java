package web.servlet;

import domain.Bean1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Demo4Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Bean1 bean1 = new Bean1();
        bean1.setInfo("我是最棒的");
        HttpSession se = request.getSession();
        //绑定
        se.setAttribute("bean1",bean1);
        System.out.println("从session中获取到的是："+se.getAttribute("bean1"));
        //解绑
        se.removeAttribute("bean1");
    }
}
