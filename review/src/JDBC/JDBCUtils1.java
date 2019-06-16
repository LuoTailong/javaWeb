package JDBC;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils1 {
    private JDBCUtils1() {
    }
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    public static void readConfig(){
        Properties p = new Properties();
        try {
            p.load(new FileReader("review\\src\\config.properties"));
            driverClass = p.getProperty("driverClass");
            url = p.getProperty("url");
            username = p.getProperty("username");
            password = p.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            readConfig();
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
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
