package JDBC;


import java.sql.*;

public class JDBC05 {

    public static void main(String[] args) {
        //1.导入驱动
        //2.注册驱动
        //3.获取连接
        //4.根据连接对象获取可以执行sql语句的对象
        //5.执行slq语句,获取结果集
        //6.操作结果集
        //7.释放资源

        method1();
//        method2();
    }

    private static void method1() {
        Connection conn = null;
        Statement stat = null;
        try {
            //2
            Class.forName("com.mysql.jdbc.Driver");
            //3.
            conn = DriverManager.getConnection("jdbc:mysql:///jdbctest", "root", "root");
            //4.
            stat = conn.createStatement();
            //5.
            String sql = "update users set username = 'admin11111' where uid = 4;";
            int i = stat.executeUpdate(sql);
            //6.
            System.out.println((i > 0) ? "修改成功" : "修改失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
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
        /*try {
            if (stat != null) {
                stat.close();
                stat = null;
                System.out.println("stat关了");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(1/0);
        System.out.println("1");
        try {
            if (conn != null) {
                conn.close();
                conn = null;
                System.out.println("conn关了");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/
    }


    public static void method2() {

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            //2.
            Class.forName("com.mysql.jdbc.Driver");
            //3.
            conn = DriverManager.getConnection("jdbc:mysql:///jdbctest", "root", "root");
            //4.
            stat = conn.createStatement();
            //5.
            String sql = "select * from users;";
            rs = stat.executeQuery(sql);
            //6.
            while (rs.next()) {
                int uid = rs.getInt("uid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(uid + "---" + username + "---" + password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    }
}
