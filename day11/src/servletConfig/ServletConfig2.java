package servletConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletConfig2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig sc = getServletConfig();
        String name = sc.getInitParameter("name");
        String gender = sc.getInitParameter("gender");
        System.out.println(name+"--"+gender);
        System.out.println("*************");
        Enumeration<String> em = sc.getInitParameterNames();
        while (em.hasMoreElements()) {
            String name2 = em.nextElement();
            System.out.println(name2+"--"+sc.getInitParameter(name2));
        }
        System.out.println("****************");

        //如果获取不到,则说明servletConfig之间是相互隔离的
        String size = sc.getInitParameter("size");
        System.out.println("size="+size);
    }
}
