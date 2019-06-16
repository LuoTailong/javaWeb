package dao.impl;

import dao.inter.ProductDao;
import domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.*;
import org.apache.commons.lang3.StringUtils;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {

    @Override
    public List<Map<String, Object>> findAllProduct() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from category c,  product p where p.cid=c.cid order by pid+0;";
        return qr.query(sql, new MapListHandler());
    }

    @Override
    public int addProduct(Product p) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "INSERT INTO product(pid, pname, market_price, shop_price, cid, is_hot, pdesc, pflag, pimage, pdate) VALUES(?,?,?,?,?,?,?,1,'products/1/c_0012.jpg',NOW());";
        Object[] obj = {p.getPid(), p.getPname(), p.getMarket_price(), p.getShop_price(), p.getCid(), p.getIs_hot(), p.getPdesc()};
        return qr.update(sql, obj);
    }

    @Override
    public Product findProductById(String pid) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from product where pid=?;";
        return qr.query(sql, new BeanHandler<>(Product.class), pid);
    }

    @Override
    public int editProduct(Product p) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "update product set pname=?,market_price=?,shop_price=?,cid=?,is_hot=?,pdesc=? where pid=?;";
        Object[] obj = {p.getPname(), p.getMarket_price(), p.getShop_price(), p.getCid(), p.getIs_hot(), p.getPdesc(), p.getPid()};
        return qr.update(sql, obj);
    }

    @Override
    public int deleteProduct(String pid) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "delete from product where pid=?;";
        return qr.update(sql, pid);
    }

    @Override
    public List<Map<String, Object>> findProductByCondition(String cid, String pname) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from category c right join product p on c.cid=p.cid where 1=1";
        //定义一个集合(因为长度可变),记录参数信息
        ArrayList<String> list = new ArrayList<>();
//        if (cid != null && cid.trim().length() > 0) {
        if (StringUtils.isNotBlank(cid)) {
            sql += " and p.cid=?";
            list.add(cid);
        }
        if (StringUtils.isNotBlank(pname)) {
            sql += " and pname like ?";
            list.add("%" + pname + "%");
        }
        sql += " order by pid+0;";
        return qr.query(sql, new MapListHandler(), list.toArray());
    }

    @Override
    public List<Product> getProductList(int begin, int numperpage, String cid) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        ArrayList<Object> list = new ArrayList<>();
        String sql = "select * from product where 1=1";
        if (StringUtils.isNotBlank(cid)) {
            sql += " and cid=?";
            list.add(cid);
        }
        sql += " order by pid+0 limit ?,?;";
        list.add(begin);
        list.add(numperpage);
        return qr.query(sql, new BeanListHandler<>(Product.class), list.toArray());
    }

    @Override
    public int findProductNum(String cid) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        ArrayList<String> list = new ArrayList<>();
        String sql = "select count(*) from product where 1=1";
        if (StringUtils.isNotBlank(cid)) {
            sql += " and cid=?;";
            list.add(cid);
        }
        return qr.query(sql, new ScalarHandler<Long>(),list.toArray()).intValue();
    }
}