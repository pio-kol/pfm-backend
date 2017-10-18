package pl.pfm.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import pl.pfm.model.categories.Categories;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;
import pl.pfm.model.category.CategoryBuilder;

@Service
public class CategoriesService {

  @Resource
  private final Categories categories;

  public CategoriesService(Categories categories) {
    this.categories = categories;
  }

  public Category getCategory(Integer id) {
    return categories.getCategoryById(id);
  }

  public int postCategory(CategoryBody categoryBody) {
    Category category = createCategory(categoryBody);
    categories.addCategory(category);
    return category.getId();
  }

  private Category createCategory(CategoryBody categoryBody) {
    return CategoryBuilder.builder()
        .withCategoryId(categories.getNextCategoryId())
        .withCategoryName(categoryBody.getCategoryName())
        .withParentCategory(categoryBody.getParentCategory())
        .build();
  }

}
