package test02_Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class test02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //3
            Properties pp = new Properties();
            pp.load(new FileReader("day04\\src\\config.properties"));
            //多态
            DataSource ds = DruidDataSourceFactory.createDataSource(pp);

            conn = ds.getConnection();
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
