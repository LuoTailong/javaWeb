package service;

import dao.ProductDao;
import domain.Product;

import java.util.ArrayList;

public class ProductService {
    public ArrayList<Product> findAllProduct() {
        ProductDao pd = new ProductDao();
        return pd.findAllProduct();
    }
}
