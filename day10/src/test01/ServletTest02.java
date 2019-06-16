package test01;

import javax.servlet.*;
import java.io.IOException;

public class ServletTest02 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化方法:携带个人简历, 离职报告, 体检证明, 面试");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("负责和浏览器的交互:每日工作, 敲代码");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁servlet:提交离职报告和交接文档");
    }
}
