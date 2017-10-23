package pl.pfm.repository;

import org.springframework.stereotype.Service;
import pl.pfm.database.Database;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;
import pl.pfm.model.category.CategoryBuilder;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CategoryRepository {

  private List<Category> categories;
  private AtomicInteger nextId = new AtomicInteger(1);

  public CategoryRepository(Database database) {
    this.categories = database.getCategories();

  }

  public void save(Category category) {
    categories.add(category);
  }

  public void save(CategoryBody categoryBody) {
    Category category = CategoryBuilder
        .builder()
        .buildCategoryWithGeneratedId(categoryBody, getNextId());
    categories.add(category);

  }

  public List<Category> findAll() {
    return categories;

  }

  public long count() {
    return categories.size();
  }

  public Category getOneById(Integer id) {
    return categories
        .stream()
        .filter(c1 -> c1.getId().equals(id))
        .findAny()
        .orElse(null);
  }

  public void delete(Category category) {
    categories.remove(category);

  }

  public void delete(Integer id) {
    Category category = getOneById(id);
    categories.remove(categories.indexOf(category));
  }

  private int getNextId() {
    return nextId.getAndIncrement();
  }


}
