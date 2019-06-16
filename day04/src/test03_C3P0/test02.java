package test03_C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //3
            //A 创建数据库连接池
            //括号中写谁就读谁,不写默认读<default-config>
            //ComboPooledDataSource cpds = new ComboPooledDataSource();
            ComboPooledDataSource cpds = new ComboPooledDataSource("oracle");
            //B 获取连接
            conn = cpds.getConnection();
            //C 获取执行sql语句对象
            stat = conn.createStatement();
            //执行sql语句
            String sql = "select * from users;";
            rs = stat.executeQuery(sql);
            //6
            while (rs.next()) {
                int uid = rs.getInt("uid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(uid+"--"+username+"--"+password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn, stat, rs);
        }
    }
}
