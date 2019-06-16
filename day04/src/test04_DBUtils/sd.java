package test04_DBUtils;

public class sd {
    public static void main(String[] args) {
        System.out.println(getSum("sfdl",1,2343,543));
    }

    public static int getSum(String name, int ... a){
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum +=a[i];
        }
        return sum;
    }
}
