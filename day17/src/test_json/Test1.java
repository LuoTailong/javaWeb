package test_json;

import domain.PCD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM province_city_district WHERE pid = -1;";
        try {
            List<PCD> list = qr.query(sql, new BeanListHandler<>(PCD.class));
            for (PCD p : list) {
                System.out.println(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
