package web;

import service.impl.CategoryServiceImpl;
import service.inter.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CategoryListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService cs = new CategoryServiceImpl();
        String str = cs.findALLCategory();

        response.setContentType("json/application;charset=utf-8");
        response.getWriter().write(str);
    }
}
