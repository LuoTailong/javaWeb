package test01_shiwuAndpichuli;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class shiwu {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            //3
            conn = JDBCUtils.getConnection();
            //4
            stat = conn.createStatement();
            //5
            String sql1 = "update accounrt set money =  money-1000 where aid = 1;";
            String sql2 = "update accounrt set money =  money+1000 where aid = 2;";
            //开启事务
            conn.setAutoCommit(false);

            int num1 = stat.executeUpdate(sql1);
            int num2 = stat.executeUpdate(sql2);
            //6
            if (num1 == 1 && num2 == 1) {
                conn.commit();
                System.out.println("转账成功");
            } else {
                conn.rollback();
                System.out.println("转账失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn, stat);
        }
    }
}
