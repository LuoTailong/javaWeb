package dao.inter;

import domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    List<Category> findAllCategory() throws SQLException;
}
