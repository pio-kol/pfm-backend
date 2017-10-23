package pl.pfm.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;
import pl.pfm.repository.CategoryRepository;

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

  public void addCategory(CategoryBody categoryBody) {
    categoryRepository.save(categoryBody);
  }
}
