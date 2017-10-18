package pl.pfm.model.categories;

import org.springframework.stereotype.Service;
import pl.pfm.database.Database;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;

import java.io.IOException;
import java.util.List;

@Service
public class Categories {

  private final Database database;

  public Categories(Database database) {
    this.database = database;
  }

  public void addCategory(Category category) {
    database.saveCategory(category);
  }

  public List<Category> getCategories() throws IOException {
    return database.getCategories();
  }


  public Category getCategoryById(Integer id) {
    return database.getCategories()
        .stream()
        .filter(category -> category.getId().equals(id))
        .findAny()
        .orElse(null);
  }

  public void removeCategory(Integer id) {
    Category foundCategory = getCategoryById(id);
    database.removeCategory(foundCategory);
  }

  public Category createCategory(CategoryBody categoryBody) {
    return database.createCategory(categoryBody);
  }

  public Integer getNextCategoryId() {
    return database.getNextCategoryId();
  }

}
