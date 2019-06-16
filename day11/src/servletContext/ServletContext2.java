package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletContext2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        String company = sc.getInitParameter("company");
        String faren = sc.getInitParameter("faren");
        System.out.println(company+"--"+faren);

        Enumeration<String> em = sc.getInitParameterNames();
        while (em.hasMoreElements()) {
            String s = em.nextElement();
            System.out.println(s+"--"+sc.getInitParameter(s));
        }
    }
}
