package test03_C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class test01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //A 设置数据库连接池
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            //B 设置参数
            cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql:///jdbctest");
            cpds.setUser("root");
            cpds.setPassword("root");
            //C 从数据库连接池中获取连接对象
            conn = cpds.getConnection();

            //4
            stat = conn.createStatement();

            //5
            String sql = "select * from users;";
            rs = stat.executeQuery(sql);

            //6
            while (rs.next()) {
                int uid = rs.getInt("uid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(uid+"--"+username+"--"+password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn, stat, rs);
        }
    }
}
