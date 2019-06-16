package web;

import domain.Product;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductConditionQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.
        request.setCharacterEncoding("utf-8");
        //2.
        String cid = request.getParameter("cid");
        String pname = request.getParameter("pname");
//        System.out.println(cid+"--"+pname);

        //5.回显
        request.setAttribute("cid",cid);
        request.setAttribute("pname",pname);

        //3.
        ProductServiceImpl ps = new ProductServiceImpl();
        List<Product> list = ps.findProductByCondition(cid,pname);

        //4.
        request.setAttribute("productList",list);
        request.getRequestDispatcher("/admin/product/list.jsp").forward(request,response);

    }
}
