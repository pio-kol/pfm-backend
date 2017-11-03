package pl.pfm.categories;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;
import pl.pfm.model.category.CategoryBuilder;

import java.util.Iterator;
import java.util.List;

@Service
public class CategoryService {

  @Resource
  private CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<Category> getCategories() {
    return categoryRepository.findAll();
  }

  public Category getOneCategory(long id) {
    return categoryRepository.findOne(id);
  }

  public long postCategory(CategoryBody categoryBody) {
    Category createdCategory = CategoryBuilder
        .builder()
        .buildCategoryWithoutId(categoryBody);
    categoryRepository.save(createdCategory);
    return createdCategory.getId();
  }

  public boolean deleteCategory(long id) {
    categoryRepository.delete(id);
    return categoryRepository.findOne(id) == null;
  }

  public void putCategory(long id, CategoryBody categoryBody) {
    Iterator<Category> categoryIterator = categoryRepository.findAll().iterator();
    Category category = null;
    while (categoryIterator.hasNext()) {
      if (categoryIterator.next().getId() == id) {
        categoryIterator.remove();
        category = CategoryBuilder
            .builder()
            .buildCategoryWithId(id, categoryBody);
      }
    }
    if (category != null) {
      categoryRepository.save(category);
    }

  }
}
