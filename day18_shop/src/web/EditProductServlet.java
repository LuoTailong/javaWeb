package web;

import domain.Product;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.ProductServiceImpl;
import service.inter.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String pid = request.getParameter("pid");
        Product p = new Product();
        try {
            BeanUtils.populate(p, request.getParameterMap());
            System.out.println(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProductService ps = new ProductServiceImpl();
        boolean flag = ps.editProduct(p);

        if (flag) {
            response.sendRedirect(request.getContextPath() + "/productListServlet");
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.setHeader("refresh","3;url=/day18_shop/admin/product/edit.jsp");
            response.getWriter().write("<h3>修改失败, 3s后跳转到商品编辑页面<h3>");
        }
    }
}
