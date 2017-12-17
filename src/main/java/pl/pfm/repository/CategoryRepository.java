package pl.pfm.repository;

import org.springframework.stereotype.Service;
import pl.pfm.database.Database;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;

import java.util.List;

@Service
public class CategoryRepository {

  Database database;

  public CategoryRepository(Database database) {
    this.database = database;
  }

  public void save(CategoryBody categoryBody) {
    database.saveCategory(categoryBody);
  }

  public void save(Category category) {
    database.saveCategory(category);
  }

  public List<Category> findAll() {
    return database.findAllCategories();
  }

  public Category findOne(long id) {
    return database.findAllCategories()
        .stream()
        .filter(c1 -> c1.getId() == id)
        .findAny()
        .orElse(null);
  }

  public boolean delete(long id) {
    return database.deleteCategory(id);
  }


}
