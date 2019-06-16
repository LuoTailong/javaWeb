package test05;

public class MyRunnable implements Runnable {
    private int tickets = 100;//1.不用加static因为只new了一个MyRunnable对象

    @Override
    public void run() {
        while (true) {
            synchronized (this){//2.锁可以用this因为只new了一个MyRunnable对象,也可以用MyRunnable.class
                if (tickets < 1) {
                    break;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets-- +"张票");
            }
        }
    }
}
