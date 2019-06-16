package response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ServletResponse4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //方式一:字符流合并版
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("我是ServletResponse4, 我给浏览器响应了一句话, 我是字符流"+new Date().toString());

        //方式二:字符流分解版
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("我是ServletResponse4, 我给浏览器响应了一句话, 我是字符流"+ new Date().toString());

        //方式三:字节流
        response.getOutputStream().write("我是ServletResponse4, 我给浏览器响应了一句话, 我是字节流".getBytes());

        /*
              注意：
                1.响应的时候, 什么时候使用字节流, 什么时候使用字符流?
                    如果只响应一些文本信息, 用字符流
                    如果是提供文件下载等功能, 用字节流
                2.字节流和字符流能不能共同使用?
                    不能,结果可能不是想要的
                3.用不用手动调用flush(),close()方法
                    因为tomcat会自动调用,所以不需要我们手动调用


        */
    }
}
