package pl.pfm.model.parentcategory;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ParentCategoryBody {

  private String parentCategoryName;

  public ParentCategoryBody() {
  }

  @JsonCreator
  public ParentCategoryBody(@JsonProperty("parentCategoryName") String parentCategoryName) {
    this.parentCategoryName = parentCategoryName;
  }

  public String getParentCategoryName() {
    return parentCategoryName;
  }
}
