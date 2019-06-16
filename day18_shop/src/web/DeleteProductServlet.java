package web;

import service.impl.ProductServiceImpl;
import service.inter.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        System.out.println(pid);
        ProductService ps = new ProductServiceImpl();
        boolean flag = ps.deleteProduct(pid);
        if (flag) {
            response.sendRedirect(request.getContextPath() + "/productListServlet");
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.setHeader("refresh","3;url=/day18_shop/productListServlet");
            response.getWriter().write("<h3>删除失败, 3s后跳转到商品展示页面<h3>");
        }
    }
}
