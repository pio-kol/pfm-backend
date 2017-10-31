package pl.pfm.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;
import pl.pfm.model.category.CategoryBuilder;
import pl.pfm.repository.CategoryRepository;

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
    return categoryRepository.save(categoryBody);
  }

  public boolean deleteCategory(Long id) {
    return categoryRepository.delete(id);
  }

  public Category putCategory(long id, CategoryBody categoryBody) {
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
    return category;
  }
}
