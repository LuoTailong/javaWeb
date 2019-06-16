package web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("监听到servletContext容器被创建,相当于项目开启"+new Date().toString());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int num = 1;
            @Override
            public void run() {
                if (num++ == 10) {
                    timer.cancel();
                }
                System.out.println("小球球,起床啦");
            }
        },3000,1000);
    }



    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("监听到ServletContext容器被销毁,相当于项目关闭");

    }
}
