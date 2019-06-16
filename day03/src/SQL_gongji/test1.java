package SQL_gongji;

import JDBCUtils.JDBCUtils02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的用户名");
        String uname = sc.nextLine();

        System.out.println("请录入您的密码:");
        String pw = sc.nextLine();

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils02.getConnection();
            stat = conn.createStatement();
            String sql = "select * from users where username='" + uname + "' and password='" + pw + "';";
//            String sql = "update users set password='123' where uname = '"+ uname +"' ;";
//           select * from users where username='sdf\'and password='sdf 'or '1=1';drop database 'jdbctest';
// select * from users where username='ds'and password=''or'1=1';drop database jdbctest;select * from users where uid='1';
            System.out.println(sql);
            int num = stat.executeUpdate(sql);
            System.out.println(rs.next() ? "登陆成功" : "用户名或者密码错误");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils02.release(conn, stat, rs);
        }
    }
}
