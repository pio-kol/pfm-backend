package pl.pfm.model.category;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryBody {

  private String name;
  private Category parentCategory;

  public CategoryBody() {
  }

  @JsonCreator
  public CategoryBody(@JsonProperty("name") String name,
      @JsonProperty("parentCategory") Category parentCategory) {
    this.name = name;
    this.parentCategory = parentCategory;
  }

  public String getCategoryName() {
    return name;
  }

  public Category getParentCategory() {
    return parentCategory;
  }

}
