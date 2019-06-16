package test03_C3P0;

import utils.C3P0Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test03 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {

            //3
            //从数据库连接池中获取连接对象
            //方式一: 获取池子 --> 获取连接对象.
            /*DataSource ds = C3P0Utils.getDataSource();
            conn = ds.getConnection();//或者conn = cpds.getConnection();*/
            //方式二: 直接从数据库连接池中获取连接对象
            conn = C3P0Utils.getConnection();

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
                System.out.println(uid + "--" + username + "--" + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Utils.release(conn, stat, rs);
        }
    }
}
