package domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Bean1 implements HttpSessionBindingListener {
    private String info;

    public Bean1() {
    }

    public Bean1(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Bean1{" +
                "info='" + info + '\'' +
                '}';
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(this+ "检测到自己的session容器绑定了");

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(this+"检测到自己的session容器解绑了");
    }
}
