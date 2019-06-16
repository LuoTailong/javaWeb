package service.impl;

import dao.impl.CategoryDaoImpl;
import dao.inter.CategoryDao;
import domain.Category;
import flexjson.JSONSerializer;
import service.inter.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public String findALLCategory() {
        CategoryDao cd = new CategoryDaoImpl();
        try {
            List<Category> list = cd.findAllCategory();
            return new JSONSerializer().exclude("*.class").serialize(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
