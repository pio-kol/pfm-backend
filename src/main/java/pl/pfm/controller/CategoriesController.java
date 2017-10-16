package pl.pfm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;
import pl.pfm.model.category.CategoryBuilder;
import pl.pfm.model.parentcategory.ParentCategoryBuilder;
import pl.pfm.service.CategoriesService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoriesController {

  private final CategoriesService service;

  public CategoriesController(CategoriesService service) {
    this.service = service;
  }


  @GetMapping(value = "/{id}")
  public Category getSingleCategory(@PathVariable("id") int id) {
    return service.getCategory(id);
  }

  @CrossOrigin
  @GetMapping(value = "/")
  public List<Category> getCategory() {

    Category c1 = CategoryBuilder
        .builder()
        .withCategoryId(1)
        .withCategoryName("Car")
        .withParentCategory(ParentCategoryBuilder
            .builder()
            .withParentCategoryId(1)
            .withParentCategoryName("Transport")
            .build())
        .build();

    Category c2 = CategoryBuilder
        .builder()
        .withCategoryId(2)
        .withCategoryName("Car")
        .withParentCategory(ParentCategoryBuilder
            .builder()
            .withParentCategoryId(1)
            .withParentCategoryName("Transport")
            .build())
        .build();

    return Arrays.asList(c1, c2);
  }


  @PostMapping
  public int postCategory(@RequestBody CategoryBody categoryBody) throws IOException {
    return service.postCategory(categoryBody);
  }

}

