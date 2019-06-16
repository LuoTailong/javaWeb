package dao;

import domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {

    public ArrayList<Product> findAllProduct() {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from product order by pid+0;";
        try {
            return (ArrayList<Product>) qr.query(sql, new BeanListHandler<>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
