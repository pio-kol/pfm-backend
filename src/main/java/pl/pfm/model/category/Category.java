package pl.pfm.model.category;

import lombok.*;
import pl.pfm.model.parentcategory.ParentCategory;

@Data
@Builder
public class Category {
  private long id;
  private String name;
  private ParentCategory parentCategory;

  public long getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public ParentCategory getParentCategory() {
    return parentCategory;
  }
}
