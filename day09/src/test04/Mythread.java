package test04;

import test03.MyThread;

public class Mythread extends Thread{
    private static int tickets = 100;

    public Mythread(String name) {
        super(name);
    }
    @Override
    public void run() {
        while (true){
            synchronized (MyThread.class){
                if (tickets < 1) {
                    break;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName()+"正在出售第"+tickets-- +"张票");
            }

            /**
             * this.getName()中的this省略也可以,因为非静态方法run中隐含着一个this.

             * 为什么非静态方法隐含一个this呢?
             因为非静态方法必须创建对象才能调用,而this代表的就是调用方法的对象,谁调用this就代表谁
             */
        }
    }
}

