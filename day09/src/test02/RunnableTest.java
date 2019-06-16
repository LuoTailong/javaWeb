package test02;

public class RunnableTest {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread th = new Thread(mr);
        for (int i = 0; i < 200; i++) {
            System.out.println("main...."+i);
        }
        th.start();
    }
}
