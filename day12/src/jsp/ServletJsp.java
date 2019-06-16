package jsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletJsp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        /*
            编写页面:
                <html>
                    <head><title>服务器给浏览器响应一个页面</title></head>
                    <body>
                        <a href='http://www.itheima.com'>黑马官网</a>
                    </body>
                </html>
         */
        response.getWriter().write("<html>");
        response.getWriter().write("<head><title>服务器给浏览响应一个页面</title></head>");
        response.getWriter().write("<body>");
        response.getWriter().write("<a href='http://www.itheima.com'>黑马官网</a>");
        response.getWriter().write("</body>");
        response.getWriter().write("</html>");
    }
}
