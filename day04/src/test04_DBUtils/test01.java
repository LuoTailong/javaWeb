package test04_DBUtils;

import org.apache.commons.dbutils.QueryRunner;
import utils.C3P0Utils;

import java.sql.SQLException;

public class test01 {
    public static void main(String[] args) {
        //执行增删改的语句
        //1.创建可以执行sql语句的对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        //2.执行sql语句,获取结果集
        String sql = "insert into users values(?,?,?);";
        try {
            Object[] arr = {null, "zhangsan", "pw123"};
            int num = qr.update(sql, arr);
            //3.操作结果集
            System.out.println(num > 0 ? "添加成功" : "添加失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
