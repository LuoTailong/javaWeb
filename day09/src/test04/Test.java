package test04;

public class Test {
    public static void main(String[] args) {
        Mythread mt1 = new Mythread("窗口1");//或直接在Test中m1.setName("窗口1")
        Mythread mt2 = new Mythread("窗口2");
        Mythread mt3 = new Mythread("窗口3");
        Mythread mt4 = new Mythread("窗口4");

        mt1.start();
        mt2.start();
        mt3.start();
        mt4.start();
    }
}
