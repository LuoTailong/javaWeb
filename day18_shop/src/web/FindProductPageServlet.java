package web;

import domain.Pagebean;
import service.impl.ProductServiceImpl;
import service.inter.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindProductPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取浏览器传过来的参数(当前页面,每页显示条数)
        int pagenum = 1;
        try {
            pagenum = Integer.parseInt(request.getParameter("pagenum"));
        }catch (Exception e){

        }
        int numperpage = 12;//这里固定显示每页12条

        //4.接收浏览器传来的cid
        String cid = request.getParameter("cid");
//        System.out.println(cid);
        //5.回显cid
        request.setAttribute("cid",cid);


        //2.
        ProductService ps = new ProductServiceImpl();
        Pagebean pb = ps.findPagebean(pagenum,numperpage,cid);

        //3.
        request.setAttribute("pagebean",pb);
        request.getRequestDispatcher("/product_list.jsp").forward(request,response);
    }
}
