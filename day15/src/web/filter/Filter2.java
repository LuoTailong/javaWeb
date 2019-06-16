package web.filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter2 implements Filter {
    public Filter2() {
        System.out.println("1.构造方法,成立安检部");
    }

    public void init(FilterConfig config) throws ServletException {
        int size = Integer.parseInt(config.getInitParameter("size"));
        System.out.println("2.初始化方法,分配"+size+"个安检人员和安检设备");

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("3.执行过率:每次访问,都会执行: 安检动作");
        chain.doFilter(req, resp);
    }

    public void destroy() {
        System.out.println("4.销毁过滤, 遣散安检人员, 收回安检设备");

    }

}
