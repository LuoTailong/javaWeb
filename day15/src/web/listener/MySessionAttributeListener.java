package web.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MySessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        //事件源对象,可以获取被监听对象的引用
        //1.获取session容器
        HttpSession hs = httpSessionBindingEvent.getSession();
        //2.获取属性名
        String name = httpSessionBindingEvent.getName();
        //3.获取属性值
        Object value = hs.getAttribute(name);
        System.out.println(hs.getId()+"sesison容器中添加属性--"+name+"=="+value);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession hs = httpSessionBindingEvent.getSession();
        String name = httpSessionBindingEvent.getName();
        Object value = hs.getAttribute(name);
        System.out.println(hs.getId()+"sesison容器中移除属性--"+name+"=="+value);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession hs = httpSessionBindingEvent.getSession();
        String name = httpSessionBindingEvent.getName();
        Object value = hs.getAttribute(name);
        System.out.println(hs.getId()+"sesison容器中替换属性--"+name+"=="+value);
    }
}
