package pl.pfm.model.category;

import pl.pfm.model.parentcategory.ParentCategory;

public class Category {

  private long id;
  private String name;
  private ParentCategory parentCategory;

  public Category() {
  }

  public Category(long id, String name, ParentCategory parentCategory) {
    this.id = id;
    this.name = name;
    this.parentCategory = parentCategory;
  }

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
