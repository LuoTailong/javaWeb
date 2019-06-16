package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class SessionServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            session的生命周期
            什么时候创建?
                方式一: 第一次调用request.getSession()的时候

                方式二: 第一次访问.jsp页面.
                    //其实底层还是调用request.getSession()

            什么时候销毁?
                方式一: session容器在服务器上的默认存活时间是30min
                        如果我们不修改这个值, 超过30min后, session就自动销毁了了

                方式二: 手动设置, 调用session.invalidate();会立即消失

                方式三:
                    服务器断电, 内存数据消失, serssion保存在内存中, 肯定也消失
        */
        HttpSession hs = request.getSession();
        hs.invalidate();

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("SessionServlet3: 测试session的生命周期"+new Date().toLocaleString());
    }
}
