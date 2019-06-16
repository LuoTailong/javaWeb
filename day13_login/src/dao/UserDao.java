package dao;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JDBCUtils;

import java.sql.SQLException;

public class UserDao {
    public User isLogin(User user) {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from user where username = ? and password = ?;";
        try {
            return qr.query(sql, new BeanHandler<>(User.class), user.getUsername(), user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
