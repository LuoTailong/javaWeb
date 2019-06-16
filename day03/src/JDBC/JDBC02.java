package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC02 {
    public static void main(String[] args) {
        //1.导入驱动
        try {
            //2.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //3.获取连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbctest", "root", "root");
            //4.根据连接对象获取可以执行sql语句的对象
            Statement stat = conn.createStatement();
            //5.执行sql语句,获取结果集
            String sql = "select * from users;";
            ResultSet rs = stat.executeQuery(sql);
            //6.判断结果集中是否有数据
            while (rs.next()) {
                int uid = rs.getInt("uid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(uid + "--" + username + "--" + password);
            }
            //7.释放资源
            rs.close();
            stat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
