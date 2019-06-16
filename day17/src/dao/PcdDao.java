package dao;

import domain.PCD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtils;

import java.util.List;

public class PcdDao {
    public List<PCD> findAllPcd(int pid) {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM province_city_district WHERE pid = ? ;";
        try {
            return qr.query(sql, new BeanListHandler<>(PCD.class), pid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
