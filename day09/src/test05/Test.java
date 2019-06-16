package test05;

public class Test {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();

        Thread th1 = new Thread(mr, "窗口1");
        Thread th2 = new Thread(mr, "窗口2");
        Thread th3 = new Thread(mr, "窗口3");
        Thread th4 = new Thread(mr, "窗口4");

        th1.start();//start()方法开启了run方法

        th2.start();
        th3.start();
        th4.start();
    }
}
