package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {
    //1.私有构造
    private DruidUtils() {
    }

    //2.定义变量,记录数据库连接池对象
    private static DataSource ds;

    //3.在静态代码块中,完成对ds的初始化操作
    static {
        Properties pp = new Properties();
        try {
            pp.load(new FileReader("day04\\src\\config.properties"));
            ds = DruidDataSourceFactory.createDataSource(pp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //4.定义方法,获取数据库连接池对象
    public static DataSource getDataSource() {
        return ds;
    }

    //5.定义方法,从数据库连接池中获取:连接对象
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //6.释放资源
    //查询语句
    public static void release(Connection conn, Statement stat, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
                System.out.println("rs关了");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                    stat = null;
                    System.out.println("stat关了");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                        conn = null;
                        System.out.println("conn关了");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //增删改语句
    public static void release(Connection conn, Statement stat) {
        try {
            if (stat != null) {
                stat.close();
                stat = null;
                System.out.println("stat关了");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    conn = null;
                    System.out.println("conn关了");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
