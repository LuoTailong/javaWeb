package web;

import service.PcdService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindPcdListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pid = Integer.parseInt(request.getParameter("pid"));
        PcdService ps = new PcdService();
        String str = ps.findALLPcd(pid);

        response.setContentType("json/application;charset=utf-8");
        response.getWriter().write(str);
    }
}
