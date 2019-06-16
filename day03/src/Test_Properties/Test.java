package Test_Properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        Properties pp = new Properties();
        //1.通过Properties从a.properties中读取数据
        try {
            pp.load(new FileReader("day03\\src\\test_json.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("修改前的数据:"+pp);

        //修改,但不会写入propeq'we'q'werties
        pp.setProperty("name", "Dalong");
        pp.setProperty("phone", "sdfdsfds");

        try {
            //2.通过Properties往test.properties中写数据
            pp.store(new FileWriter("day03\\src\\test_json.properties"),"Dalong");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("修改后的数据:"+pp);
    }
}
