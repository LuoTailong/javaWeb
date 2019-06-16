package JDBC;


import com.mysql.jdbc.Driver;

import java.sql.*;

public class JDBC01 {

    public static void main(String[] args) {
        //1.导入驱动
        try {
            //2.注册驱动
            DriverManager.registerDriver(new Driver());
            //3.获取连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbctest", "root", "root");
            //4.根据连接对象u=获取可以执行的SQL语句对象
            Statement stat = conn.createStatement();
            //5.执行sql语句,获得结果集
            String sql = "select * from users;";
            ResultSet rs = stat.executeQuery(sql);
            //6.操作结果集
            while (rs.next()) {
                int uid = rs.getInt("uid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(uid + "..." + username + "..." + password);
            }
            //7.释放资源
            rs.close();
            stat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
