package http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletHttp4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ip = request.getRemoteAddr();
        //用ip可让结果更明显地证明两个对象传递是一组(request, response)
        request.setAttribute("ip", ip);
        //请求转发:
        // 1.getRequestDispatcher找到转发对象  2.forward执行动作
        request.getRequestDispatcher("/servletHttp5").forward(request, response);
    }
}
