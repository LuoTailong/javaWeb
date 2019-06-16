package JDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Druidutils {
    private Druidutils() {
    }

    private static DataSource ds;
    static {
        Properties pp = new Properties();
        try {
            pp.load(new FileReader("review\\src\\config.properties"));
            ds = DruidDataSourceFactory.createDataSource(pp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){return ds;}

    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void release(Connection conn, Statement stat, ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
                rs=null;
                System.out.println("rs关了");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (stat != null) {
                    stat.close();
                    stat=null;
                    System.out.println("stat关了");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (conn != null) {
                        conn.close();
                        conn=null;
                        System.out.println("conn关了");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void release(Connection conn, Statement stat){
        try {
            if (stat != null) {
                stat.close();
                stat=null;
                System.out.println("stat关了");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                    conn=null;
                    System.out.println("conn关了");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
