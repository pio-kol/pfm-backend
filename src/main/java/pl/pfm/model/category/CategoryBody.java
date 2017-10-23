package pl.pfm.model.category;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.pfm.model.parentcategory.ParentCategory;

public class CategoryBody {

  private String name;
  private ParentCategory parentCategory;

  public CategoryBody() {
  }

  @JsonCreator
  public CategoryBody(@JsonProperty("name") String name,
      @JsonProperty("parentCategory") ParentCategory parentCategory) {
    this.name = name;
    this.parentCategory = parentCategory;
  }

  public String getCategoryName() {
    return name;
  }

  public ParentCategory getParentCategory() {
    return parentCategory;
  }

}
