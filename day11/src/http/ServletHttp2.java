package http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletHttp2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getMethod());
        System.out.println(request.getRequestURI());
        System.out.println(request.getProtocol());
        System.out.println(request.getContextPath());
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getLocalPort());

        System.out.println(request.getHeader("Accept"));
        System.out.println(request.getHeader("User-Agent"));
        System.out.println("*************************");

        Enumeration<String> em = request.getHeaderNames();
        while (em.hasMoreElements()) {
            String name = em.nextElement();
            System.out.println(name+"="+request.getHeader(name));
        }
    }
}
