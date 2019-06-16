package test02_Druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.Driver;
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
            //3
            //conn = JDBCUtils.getConnection();
            //A 创建数据库连接池
            DruidDataSource dds = new DruidDataSource();
            //B 设置数据库连接池的参数
            //必要参数
            dds.setDriver(new Driver());
            dds.setUrl("jdbc:mysql:///jdbctest");
            dds.setUsername("root");
            dds.setPassword("root");
            //可选参数


            conn = dds.getConnection();

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
            /**
             关于conn.close();的说:
             如果conn是我们自己手动创建的, 调用close()就是销毁连接对象.
             如果conn是我们从数据库连接池中获取的, 调用close()就是: 自动归还连接对象到数据库连接池.
             */
        }
    }
}
