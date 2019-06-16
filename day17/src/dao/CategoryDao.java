package dao;

import domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    public List<Category> findCategoryList() {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from category;";
        try {
            return qr.query(sql,new BeanListHandler<>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
