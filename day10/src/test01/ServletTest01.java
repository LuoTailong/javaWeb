package test01;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

public class ServletTest01 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }



    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.getWriter().write("this is ServletTest01"+new Date().toLocaleString());
    }


    @Override
    public void destroy() {

    }












    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    @Override
    public String getServletInfo() {
        return null;
    }
}
