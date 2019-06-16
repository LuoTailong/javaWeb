package service.inter;

import domain.Pagebean;
import domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProduct();

    boolean addProduct(Product p);

    Product findProductById(String pid);

    boolean editProduct(Product p);

    boolean deleteProduct(String pid);

    List<Product> findProductByCondition(String cid, String pname);

    Pagebean findPagebean(int pagenum, int numperpage, String cid);
}
