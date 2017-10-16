package pl.pfm.model.category;

import pl.pfm.model.parentcategory.ParentCategory;

public class Category {

  private Integer categoryId;
  private String categoryName;
  private ParentCategory parentCategory;

  public Category() {
  }

  public Category(Integer categoryId, String categoryName, ParentCategory parentCategory) {
    this.categoryId = categoryId;
    this.categoryName = categoryName;
    this.parentCategory = parentCategory;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public ParentCategory getParentCategory() {
    return parentCategory;
  }
}
