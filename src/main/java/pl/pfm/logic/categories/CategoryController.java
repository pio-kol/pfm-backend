package pl.pfm.logic.categories;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;

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
  @GetMapping(value = "/{id}")
  public Category getOneCategory(@PathVariable long id) {
    return categoryService.getOneCategory(id);
  }

  @CrossOrigin
  @PostMapping
  public long postCategory(@RequestBody CategoryBody categoryBody) throws IOException {
    return categoryService.postCategory(categoryBody);
  }

  @CrossOrigin
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> deleteCategory(@PathVariable long id) {
    return (categoryService.deleteCategory(id) ?
        ResponseEntity.ok() : ResponseEntity.notFound()).build();

  }

  @CrossOrigin
  @PutMapping(value = "/{id}")
  public Category putCategory(@PathVariable long id, @RequestBody CategoryBody categoryBody) {
    return  categoryService.putCategory(id, categoryBody);
  }

}

