package test03;

public class MyThread extends Thread {
    private static int tickets = 51;

    @Override
    public void run() {
        while (true) {
            if (tickets < 1) {
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("正在出售第" + tickets-- + "张票");
        }

        /**出现两个问题的原因:
         * 1.出现负值
         剩余1张票时,代码正常执行,四个线程都过了if(),再执行ticket--后就会出现负值
         (加上sleep方法是为了增加负值出现的概率)
         * 2.出现重复值: 关键点:tickets--
         tickets--  相当于: tickets = tickets - 1;
         上述的代码做了3件事:
         1. 读值.
         2. 改值.
         3. 赋值.
         当一个线程还没有来得及执行3之前, 被别的线程抢走资源了, 就有可能发生: 重复值.*/
    }
}
