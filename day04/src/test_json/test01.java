package test_json;

public class test01 {
    public static void main(String[] args) {
        sdf();
    }

    private static void sdf() {
        int num = 0;
        int[] arr = {1,23,43,45,45,56,56,5,76};
        for (int i = 0; i < arr.length; i++) {
            num++;
        }
        System.out.println(num);
    }
}
