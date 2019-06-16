package test02_Druid;

import utils.DruidUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class test03 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //3 从数据库连接池中获取对象
            //方式一: 先获取数据库连接池 再获取连接对象
//            DataSource ds = DruidUtils.getDataSource();
//            conn = ds.getConnection();
            //方式二: 直接从数据库连接池中获取连接
           conn = DruidUtils.getConnection();
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
            DruidUtils.release(conn, stat, rs);
        }
    }
}
