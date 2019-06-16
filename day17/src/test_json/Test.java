package test_json;

import domain.Category;
import flexjson.JSONSerializer;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Category c = new Category(1, "手机数码");
        String str = new JSONSerializer().exclude("*.class").serialize(c);
        System.out.println(str);

        System.out.println("------------");

        List<Category> list = new ArrayList<>();
        list.add(new Category(1,"办公用品"));
        list.add(new Category(2,"手机数码"));
        list.add(new Category(3,"家居护理"));
        String str1 = new JSONSerializer().exclude("*.class").serialize(list);
        System.out.println(str1);
    }
}
