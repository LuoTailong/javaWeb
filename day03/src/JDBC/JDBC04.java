package JDBC;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC04 {

    @Test
    public void method1() {
        //1.导入驱动
        try {
            //2.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //3.获取连接
            Connection conn = DriverManager.getConnection("jdbc:mysql:///jdbctest", "root", "root");
            //4.根据连接获取可执行sql语句的对象
            Statement stat = conn.createStatement();
            //5.执行sql语句,获得结果集
            String sql = "insert into users values(null, 'admin05', 'pw555');";
            int num = stat.executeUpdate(sql);
            //6.操作结果集
            System.out.println(num > 0 ? "添加成功" : "添加失败");
            //7.释放资源
            stat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method2() {
        //1.导入驱动
        try {
            //2.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //3.获取连接
            Connection conn = DriverManager.getConnection("jdbc:mysql:///jdbctest", "root", "root");
            //4.根据连接获取可执行sql语句的对象
            Statement stat = conn.createStatement();
            //5.执行sql语句,获得结果集
            String sql = "delete from users where uid = 1;";
            int num = stat.executeUpdate(sql);
            //6.操作结果集
            System.out.println(num > 0 ? "删除成功" : "删除失败");
            //7.释放资源
            stat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method3() {
        //1.导入驱动
        try {
            //2.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //3.获取连接
            Connection conn = DriverManager.getConnection("jdbc:mysql:///jdbctest", "root", "root");
            //4.根据连接获取可执行sql语句的对象
            Statement stat = conn.createStatement();
            //5.执行sql语句,获得结果集
            String sql = "update users set username = 'admin888' where uid = 3;";
            int num = stat.executeUpdate(sql);
            //6.操作结果集
            System.out.println(num > 0 ? "更新成功" : "更新失败");
            //7.释放资源
            stat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method4() {
        //1.导入驱动
        try {
            //2.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //3.获取连接
            Connection conn = DriverManager.getConnection("jdbc:mysql:///jdbctest", "root", "root");
            //4.根据连接获取可执行sql语句的对象
            Statement stat = conn.createStatement();
            //5.执行sql语句,获得结果集
            String sql = "select * from users;";
            ResultSet rs = stat.executeQuery(sql);
            //6.操作结果集
            while (rs.next()) {
                int uid = rs.getInt("uid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(uid + "--" + username + "--" + password);
            }
            //7.释放资源
            stat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
