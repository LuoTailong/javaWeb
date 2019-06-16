package 装饰设计模式;

public class Student implements Coder{

    @Override
    public void code() {
        System.out.println("Java核心基础");
        System.out.println("面向对象, 封装, 继承, 多态");
        System.out.println("String类, 集合, IO流");
        System.out.println("多线程, 网络编程");
    }

    public void smoke(){
        System.out.println("学生抽烟");
    }
}
