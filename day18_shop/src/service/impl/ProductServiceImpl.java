package service.impl;

import dao.impl.ProductDaoImpl;
import dao.inter.ProductDao;
import domain.Category;
import domain.Pagebean;
import domain.Product;
import org.apache.commons.beanutils.BeanUtils;
import service.inter.ProductService;
import utils.CommonUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    ProductDao pd = new ProductDaoImpl();

    @Override
    public List<Product> findAllProduct() {
        List<Product> list = new ArrayList<>();
        try {
            List<Map<String, Object>> maps = pd.findAllProduct();
            for (Map<String, Object> map : maps) {
                Product p = new Product();
                Category c = new Category();
                BeanUtils.populate(p, map);
                BeanUtils.populate(c, map);
                p.setCategory(c);
                list.add(p);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addProduct(Product p) {
        try {
            p.setPid(CommonUtils.getUUID());
            int num = pd.addProduct(p);
            return num > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product findProductById(String pid) {
        try {
            return pd.findProductById(pid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean editProduct(Product p) {
        try {
            return pd.editProduct(p) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(String pid) {
        try {
            return pd.deleteProduct(pid) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> findProductByCondition(String cid, String pname) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            List<Map<String, Object>> maps = pd.findProductByCondition(cid, pname);
            for (Map<String, Object> map : maps) {
                Product p = new Product();
                Category c = new Category();
                BeanUtils.populate(p, map);
                BeanUtils.populate(c, map);
                p.setCategory(c);
                list.add(p);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Pagebean findPagebean(int pagenum, int numperpage, String cid) {
        //1.创建Pagebean对象
        Pagebean pb = new Pagebean();


        //2.设置pb对象属性
        try {
            //2.1当前页数
            pb.setPagenum(pagenum);

            //2.2每页显示的条数
            pb.setNumperpage(numperpage);

            //2.3获取当前页要显示数据, 查询数据库
            //2.3.1获取当前页的数据起始索引
            int begin = numperpage * (pagenum - 1);

            //2.3.2获取当前页要显示数据
            //select * from product order by pid+0 limit 0,3;
            List<Product> list = pd.getProductList(begin, numperpage,cid);
            pb.setProductList(list);

            //2.4总记录数: 查询数据库
            int num = pd.findProductNum(cid);
            pb.setTotal(num);

            //2.5总页数
            int totalPage = (num + numperpage - 1) / numperpage;
            pb.setTotalpage(totalPage);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //3.返回给web层
        return pb;
    }
}
