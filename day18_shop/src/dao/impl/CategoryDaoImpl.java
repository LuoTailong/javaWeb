package dao.impl;

import dao.inter.CategoryDao;
import domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> findAllCategory() throws SQLException {

        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from category;";
        return qr.query(sql,new BeanListHandler<>(Category.class));
    }
}
