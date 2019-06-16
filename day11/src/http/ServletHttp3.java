package http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletHttp3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Post独有的解决中文乱码的问题
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = "+username);
        System.out.println("password = "+password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //核心思想: 保证码表一致即可
        //方式一:
        /*String encode = URLEncoder.encode(username, "iso-8859-1");
        String username2 = URLDecoder.decode(encode, "utf-8");*/

        //方式二:
        /*//对最终的值, 按照"iso-8859-1"码表, 转成字节数组.
        byte[] bytes = username.getBytes("iso-8859-1");
        //把字节数组按照"utf-8"码表转成 字符串
        String username2 = new String(bytes, "utf-8");*/

        //方式三:
        String username2 = new String(username.getBytes("iso-8859-1"), "utf-8");


        System.out.println("username = "+username2);
        System.out.println("password = "+password);
    }
}
