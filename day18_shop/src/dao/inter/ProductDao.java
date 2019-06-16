package dao.inter;

import domain.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ProductDao {
    List<Map<String, Object>> findAllProduct() throws SQLException;

    int addProduct(Product p) throws SQLException;

    Product findProductById(String pid) throws SQLException;

    int editProduct(Product p) throws SQLException;

    int deleteProduct(String pid) throws SQLException;

    List<Map<String, Object>> findProductByCondition(String cid, String pname) throws SQLException;

    List<Product> getProductList(int begin, int numperpage, String cid) throws SQLException;

    int findProductNum(String cid) throws SQLException;
}
