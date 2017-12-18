package pl.pfm.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;
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

  public void postCategory(CategoryBody categoryBody) {
    categoryRepository.save(categoryBody);
  }

  public boolean deleteCategory(long id) {
    return categoryRepository.delete(id);
  }

  public void putCategory(long id, CategoryBody categoryBody) {
    Iterator<Category> categoryIterator = categoryRepository.findAll().iterator();
    while (categoryIterator.hasNext()) {
      if (categoryIterator.next().getId() == id) {
        categoryIterator.remove();
        Category category = Category.builder()
            .id(id)
            .name(categoryBody.getCategoryName())
            .parentCategory(categoryBody.getParentCategory())
            .build();
        categoryRepository.save(category);
      }
    }

  }
}
