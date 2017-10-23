package pl.pfm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBuilder;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoriesController {

  @CrossOrigin
  @GetMapping(value = "/")
  public List<Category> getCategories() {

    Category c1 = CategoryBuilder
        .builder()
        .withCategoryId(1)
        .withCategoryName("Car")
        .withParentCategory(null)
        .build();

    Category c2 = CategoryBuilder
        .builder()
        .withCategoryId(2)
        .withCategoryName("Car")
        .withParentCategory(null)
        .build();

    return Arrays.asList(c1, c2);
  }

}

