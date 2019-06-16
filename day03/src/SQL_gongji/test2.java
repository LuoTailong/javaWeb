package SQL_gongji;

import JDBCUtils.JDBCUtils02;

import java.sql.*;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入您的用户名:");
        String uname = sc.nextLine();

        System.out.println("请输入您的密码:");
        String pw = sc.nextLine();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = JDBCUtils02.getConnection();
        String sql = "select * from users where username=? and password=?;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, pw);
            rs = ps.executeQuery();
            System.out.println(rs.next() ? "登陆成功" : "用户名或密码错误");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils02.release(conn, ps, rs);
        }
    }
}
