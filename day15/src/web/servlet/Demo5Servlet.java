package web.servlet;

import domain.Bean2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo5Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //钝化：关闭服务器时,将session从内存保存到硬盘
        Bean2 bean2 = new Bean2("林青霞","香港");
        request.getSession().setAttribute("bean2",bean2);
        System.out.println("香港的林青霞进入了session容器中");
    }
}
