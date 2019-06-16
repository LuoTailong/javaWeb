package web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class GenericEncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //1.解决get,post方式的乱码问题
        //获取浏览器发送请求时数据的提交方式,但此时无法调用request.getMehtod, 因为ServletRequest是HttpServletRequest的父类, 父类不能调用子类的特有方法
        //向下转型解决
        HttpServletRequest hsr = (HttpServletRequest) request;

        //2.解决hsr中的乱码
        //因为hsr中记录的是乱码数据,所以用装饰设计模式对hsr的功能进行升级,此处采用内部类的形式
        //MyServletRequest msr = new MyServletRequest(hsr);
        // 因为装饰后的类和装饰前是一个类,所以我们可一直接用hsr接
        hsr = new MyServletRequest(hsr);

        //3.解决响应时的乱码
        response.setContentType("text/html;charset=utf-8");

        //放行
        chain.doFilter(hsr, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

         /*
            装饰设计模式的三大步:
                1) 获取被装饰类的引用.
                2) 在构造方法中传入要装饰的对象.
                3) 对该对象的功能进行升级.
         */
    class MyServletRequest/*装饰类*/ extends HttpServletRequestWrapper {
        //观察ServletRequest跟接口可发现,继承HttpServletRequestWrapper原因：
        //1.如果继承ServletRequest接口,需要重写所有抽象方法
        //2.如果继承ServletRequestWrapper,没有getMethod方法
        //3.继承HttpServletRequestWrapper类,需要哪个方法重写即可,不用全部重写,并且有getMethod方法
        private HttpServletRequest hsr;

        public MyServletRequest(HttpServletRequest hsr) {
            super(hsr);//初始化父类
            this.hsr = hsr;
        }

        //定义标记使其不执行第二遍
        boolean flag = true;

        //升级getParameter()方法,因为hsr自带的getParameter方法获取到的是乱码的数据,升级为编解码一致的方法
        @Override
        public Map<String, String[]> getParameterMap() {
            //判断浏览器提交方式
            if ("post".equalsIgnoreCase(hsr.getMethod())) {
                //解决post方式的乱码问题
                try {
                    hsr.setCharacterEncoding("utf-8");
                    return hsr.getParameterMap();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else if ("get".equalsIgnoreCase(hsr.getMethod())) {
                //解决get方式的乱码问题
                Map<String, String[]> map = hsr.getParameterMap();
                if (map != null) {
                    if (flag) {
                        for (String name : map.keySet()) {
                            String[] values = map.get(name);
                            //进行遍历, 对每一个数据都进行编解码一致
                            for (int i = 0; i < values.length; i++) {
                                try {
                                    values[i] = new String(values[i].getBytes("iso-8859-1"), "utf-8");
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        flag = false;
                    }
                }
                return map;
            }
            return hsr.getParameterMap();
        }

        //升级getParameter()方法,根据指定的属性名,获取属性值的第一个(该方法父类中就是这样定义的)
        @Override
        public String getParameter(String name) {
            //获取解决乱码后的数据
            Map<String, String[]> map = this.getParameterMap();//this代表的是当前类,调用getParameterMap()是已经处理过的,this不是代表hsr
            if (map != null) {
                String[] values = map.get(name);//抽取数组alt+shift+L
                return values != null && values.length > 0 ? values[0] : null;//经验证,长度为0的数组不为空,所以要用非空和length>0两个条件判断
               //return values[0] == null ? null : values[0];//value若为空则values[0]会报空指针
            }
            return null;
        }

        //升级getParameterValues()方法,根据指定的属性名,获取所有属性值
        @Override
        public String[] getParameterValues(String name) {
            Map<String, String[]> map = this.getParameterMap();
            if (map != null) {
                String[] values = map.get(name);
                return values == null ? null : values;
            }
            return null;
        }
    }
}
