package JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_JDBCUtils02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils02.getConnection();
            stat = conn.createStatement();
            String sql = "select * from users;";
            rs = stat.executeQuery(sql);
            while (rs.next()){
                int uid = rs.getInt("uid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(uid+"--"+username+"--"+password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCUtils02.release(conn, stat, rs);
    }
}
