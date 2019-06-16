package 装饰设计模式;

public class HeiMaStudent implements Coder {
    /*
        1.获取被装饰类的引用
        2.在构造方法中传入被装饰类的引用
        3.对其功能及进行升级
    */

    private Student s;

    public HeiMaStudent(Student s) {
        this.s = s;
    }

    @Override
    public void code() {
        s.code();
        System.out.println("JavaWeb核心基础, SSH三大框架, SpringMVC");
        System.out.println("搜索引擎, 爬虫");
        System.out.println("品优购项目");
        System.out.println("大数据三大框架和案例");
        System.out.println("Python入门和机器学习");
    }
}
