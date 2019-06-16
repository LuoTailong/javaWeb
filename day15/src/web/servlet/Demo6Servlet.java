package web.servlet;

import domain.Bean2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo6Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //活化：开启服务器时,将session从硬盘提交到内存
        Bean2 bean2 = (Bean2) request.getSession().getAttribute("bean2");
        System.out.println(bean2);
    }
}
