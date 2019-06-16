package JDBCUtils;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils02 {
    //1.构造私有
    private JDBCUtils02() {
    }

    //2.定义变量,记录读取到的配置文件中的数据
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    //3.定义方法,读取配置文件中的信息,然后将读取到的值赋值给变量
    private static void readConfig() {
        Properties pp = new Properties();
        try {
            pp.load(new FileReader("day03\\src\\config.properties"));
            driverClass = pp.getProperty("driverClass");
//加引号是因为这里的driverClass是一个常量properties中存储的是("driverClass", "com.mysql.jdbc.Driver")键值对,ResultSet同理
            url = pp.getProperty("url");
            username = pp.getProperty("username");
            password = pp.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //4.注册驱动
    static {
        try {
            readConfig();
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //5.获取连接对象
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //6.释放资源
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
