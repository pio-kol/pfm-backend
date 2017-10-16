package pl.pfm.model.category;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.pfm.model.parentcategory.ParentCategory;

public class CategoryBody {

  private String categoryName;
  private ParentCategory parentCategory;

  public CategoryBody() {
  }

  @JsonCreator
  public CategoryBody(@JsonProperty("categoryName") String categoryName,
      @JsonProperty("parentCategory") ParentCategory parentCategory) {
    this.categoryName = categoryName;
    this.parentCategory = parentCategory;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public ParentCategory getParentCategory() {
    return parentCategory;
  }

}
