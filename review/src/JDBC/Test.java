package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils1.getConnection();
            stat = conn.createStatement();
            String sql ="delete from users where uid=5;";
            int i = stat.executeUpdate(sql);
            System.out.println(i>0?"删除成功":"删除失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils1.release(conn, stat);
    }
}
