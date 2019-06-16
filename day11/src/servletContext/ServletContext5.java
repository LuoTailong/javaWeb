package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletContext5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前项目下所有资源的绝对路径
        //项目下的资源是相对于web文件夹的路径来讲的
        ServletContext sc = getServletContext();
        String pathA = sc.getRealPath("WEB-INF/classes/a.txt");
        String pathB = sc.getRealPath("WEB-INF/b.txt");
        String pathC = sc.getRealPath("c.txt");
        //获取不到d.txt的路径因为在web之外
        String pathD = sc.getRealPath("d.txt");

        System.out.println("a.txt = "+pathA);
        System.out.println("b.txt = "+pathB);
        System.out.println("c.txt = "+pathC);
        System.out.println("d.txt = "+pathD);
        System.out.println("*******************************");

        //获取文件类型
        String name1 = "a.txt";
        String name2 = "b.jpg";
        String name3 = "c.avi";
        System.out.println(sc.getMimeType(name1));
        System.out.println(sc.getMimeType(name2));
        System.out.println(sc.getMimeType(name3));
        System.out.println(sc.getMimeType(pathA));
        System.out.println(sc.getMimeType(pathB));
        System.out.println("*******************************");

        System.out.println(getServletContext().getContextPath());
        System.out.println(request.getContextPath());
    }
}
