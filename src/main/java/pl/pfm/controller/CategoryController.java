package pl.pfm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;
import pl.pfm.service.CategoryService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

  private CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @CrossOrigin
  @GetMapping(value = "/")
  public List<Category> getCategories() {
    return categoryService.getCategories();
  }

  @CrossOrigin
  @PostMapping
  public void postCategory(@RequestBody CategoryBody categoryBody) throws IOException {
    categoryService.addCategory(categoryBody);
  }

}

