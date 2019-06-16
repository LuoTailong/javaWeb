package web;

import domain.Product;
import service.impl.ProductServiceImpl;
import service.inter.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService ps = new ProductServiceImpl();
        List<Product> list = ps.findAllProduct();

        request.setAttribute("productList",list);
        request.getRequestDispatcher("admin/product/list.jsp").forward(request,response);
    }
}
