package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Demo3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //需求1: 监听request容器的创建和销毁
        /*request.setAttribute("username","张三");
        System.out.println(request.getAttribute("username"));*/

        //需求2: 监听session容器的创建和销毁
        /*HttpSession se = request.getSession();
        se.setAttribute("city", "北京");
        System.out.println(se.getAttribute("city"));
        se.invalidate();*/

        //需求4: 监听session容器中属性的变化

        //获取session容器
        HttpSession se = request.getSession();
        //1.添加属性
        se.setAttribute("city","北京市");
        //2.修改属性
        se.setAttribute("city","深圳市");

        //3.删除属性
        se.removeAttribute("city");

    }
}
