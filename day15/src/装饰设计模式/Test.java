package 装饰设计模式;

public class Test {
    public static void main(String[] args) {
        Student s = new Student();
        s.code();
        s.smoke();
        System.out.println("-----------------------------");
        Student2 s2 = new Student2();
        s2.code();
        s2.smoke();
        System.out.println("-----------------------------");

        HeiMaStudent hs = new HeiMaStudent(s);
        hs.code();
    }
}
