package web;

import domain.Product;
import service.impl.ProductServiceImpl;
import service.inter.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditUIProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        //System.out.println(pid);
        //根据id查询获取商品信息
        ProductService ps = new ProductServiceImpl();
        Product p = ps.findProductById(pid);
        //将商品装到request容器中
        request.setAttribute("product",p);
        //请求转发到edit.jsp
        request.getRequestDispatcher("/admin/product/edit.jsp").forward(request,response);

    }
}
