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

public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收浏览器传来的数据,解决乱码
        request.setCharacterEncoding("utf-8");
        Product p = new Product();
        try {
            BeanUtils.populate(p, request.getParameterMap());
            ProductService ps = new ProductServiceImpl();
            boolean flag = ps.addProduct(p);

            if (flag) {
                response.sendRedirect(request.getContextPath()+"/productListServlet");
            }else {
                response.setContentType("text/html;charset=utf-8");
                response.setHeader("refresh","3;url=/day18_shop/admin/product/add.jsp");
                response.getWriter().write("<h2>修改失败, 3s后跳转到添加页面");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
