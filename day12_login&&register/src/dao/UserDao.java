package dao;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JDBCUtils;

import java.sql.SQLException;

public class UserDao {
    public User isLoign(User user) {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from user where username=? and password=?;";
        try {
            return qr.query(sql, new BeanHandler<>(User.class), user.getUsername(), user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void registerUser(User user) {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?);";
        Object[] obj = {null, user.getUsername(), user.getPassword(), user.getNickname()};
        try {
            qr.update(sql, obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
