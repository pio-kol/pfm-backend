package pl.pfm.model.category;

import pl.pfm.model.parentcategory.ParentCategory;

public class Category {

  private Integer id;
  private String name;
  private ParentCategory parentCategory;

  public Category() {
  }

  public Category(Integer id, String name, ParentCategory parentCategory) {
    this.id = id;
    this.name = name;
    this.parentCategory = parentCategory;
  }

  public Integer getCategoryId() {
    return id;
  }

  public String getCategoryName() {
    return name;
  }

  public ParentCategory getParentCategory() {
    return parentCategory;
  }
}
