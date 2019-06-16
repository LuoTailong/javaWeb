package service;

import dao.CategoryDao;
import domain.Category;
import flexjson.JSONSerializer;

import java.util.List;

public class CategoryService {

    public String findCategoryList() {
        CategoryDao cd = new CategoryDao();
        List<Category> list = cd.findCategoryList();
        return new JSONSerializer().exclude("*.class").serialize(list);
    }
}
