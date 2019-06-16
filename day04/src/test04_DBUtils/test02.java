package test04_DBUtils;

import domain.Users;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;
import utils.DruidUtils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//DBUtils执行查询语句
public class test02 {
    /**
     * 1.把第一行数据封装成"object[]>
     * ArrayHandler
     */
    @Test
    public void method1() {
        //1.获取可以执行sql语句的对象
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2.执行sql语句,获取结果集
        String sql = "select * from users where uid=?;";
        try {
            Object[] arr = qr.query(sql, new ArrayHandler(), 2);
            //3. 操作结果集
            System.out.println(Arrays.toString(arr));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 2.把每一行数据都封装成Object[],然后整体放入:List<Object[]>
     * ArrayListHandler
     */
    @Test
    public void method2() {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from users;";
        try {
            List<Object[]> list = qr.query(sql, new ArrayListHandler());
            for (Object[] arr : list) {
                System.out.println(Arrays.toString(arr));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 3.把第一行数据封装成:Map<列名,该列的值>Map<String,Object>
     * MapHandler
     */
    @Test
    public void method3() {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from users where uid=?;";
        try {
            Map<String, Object> map = qr.query(sql, new MapHandler(), 2);
            System.out.println(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 4.把每一行数据封装成Map<列名,该列的值>,然后整体放入:ListMap<列名,该列的值>
     * MapListHandler
     */
    @Test
    public void method4() {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from users;";
        try {
            List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
            for (Map<String, Object> map : list) {
                System.out.println(map);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 5.把第一行的数据封装成:JavaBean对象
     * BeanHandler
     */
    @Test
    public void method5() {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from users where uid = ?;";
        try {
            Users users = qr.query(sql, new BeanHandler<>(Users.class), 1);
            System.out.println(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 6.把每一行数据都封装成JavaBean对象,然后整体放入:List<JavaBean>类
     * BeanListHandler
     */
    @Test
    public void method6() {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from users;";
        try {
            List<Users> list = qr.query(sql, new BeanListHandler<>(Users.class));
            for (Users users : list) {
                System.out.println(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 7.把指定的一列数据都封装到List<Object>
     * ColumnListHandler
     */
    @Test
    public void method7() {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from users;";
        try {
            List<Object> list = qr.query(sql, new ColumnListHandler("username"));
            for (Object o : list) {
                System.out.println(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 8.进行单值查询, 所谓的单值查询: 一行一列的数据
     * ScalarHandler, 一般聚合函数使用
     */
    @Test
    public void method8() {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select count(*) from users;";
        try {
            Object obj = qr.query(sql, new ScalarHandler());
            System.out.println(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 9.把每一行数据都封装成Map<列名,该列的值>,然后整体放入:Map<指定的列名,该列的值>
     * KeyedHandler
     */

    @Test
    public void method9() {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from users;";
        try {
            Map<Object, Map<String, Object>> map = qr.query(sql, new KeyedHandler());
            for (Object key : map.keySet()) {
                System.out.println(key + "--" + map.get(key));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
