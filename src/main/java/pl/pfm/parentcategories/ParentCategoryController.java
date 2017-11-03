package pl.pfm.parentcategories;

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
import pl.pfm.model.parentcategory.ParentCategory;
import pl.pfm.model.parentcategory.ParentCategoryBody;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/parent-categories/")
public class ParentCategoryController {

  private ParentCategoryService parentCategoryService;

  public ParentCategoryController(ParentCategoryService parentCategoryService) {
    this.parentCategoryService = parentCategoryService;
  }

  @CrossOrigin
  @GetMapping(value = "/")
  public List<ParentCategory> getParentCategories() {
    return parentCategoryService.getParentCategories();
  }

  @CrossOrigin
  @GetMapping(value = "/{id}")
  public ParentCategory getOnePArentCategory(@PathVariable long id) {
    return parentCategoryService.getOneParentCategory(id);
  }

  @CrossOrigin
  @PostMapping
  public long postParentCategory(@RequestBody ParentCategoryBody parentCategoryBody)
      throws IOException {
    return parentCategoryService.postParentCategory(parentCategoryBody);
  }

  @CrossOrigin
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> deleteParentCategory(@PathVariable long id) {
    return (parentCategoryService.deleteParentCategory(id) ?
        ResponseEntity.ok() : ResponseEntity.notFound()).build();

  }

  @CrossOrigin
  @PutMapping(value = "/{id}")
  public void putParentCategory
      (@PathVariable long id, @RequestBody ParentCategoryBody parentCategoryBody) {
    parentCategoryService.putParentCategory(id, parentCategoryBody);
  }

}
