package test01_shiwuAndpichuli;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class pichuli {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;

        try {
            //3
            conn = JDBCUtils.getConnection();
            //4
            stat = conn.createStatement();
            //5 执行sql语句,通过批处理的方式实现
            /**
             * 需求1:把account表中的aid为1的数据的money改为3000
             * 需求2:往account表中的添加三条数据
             * 需求3:删除users表中的uid>2的数据
             */
            String sql1 = "update account set money = 3000 where aid = 1;";
            String sql2 = "insert into account values(null, '赵丽颖', 2000),(null, '杨超越', 3000),(null, '武松', 5000);";
            String sql3 = "delete from users where uid>2;";
           // String sql4 = "select * from users;";
            //A 添加批处理
            stat.addBatch(sql1);
            stat.addBatch(sql2);
            stat.addBatch(sql3);
           // stat.addBatch(sql4);

            //B 执行批处理,获取结果集
            int[] arr = stat.executeBatch();
            System.out.println(Arrays.toString(arr));

            //C 清空批处理
            stat.clearBatch();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //7
            JDBCUtils.release(conn, stat);
        }
    }
}
