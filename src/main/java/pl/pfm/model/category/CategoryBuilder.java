package pl.pfm.model.category;

import pl.pfm.model.parentcategory.ParentCategory;

public class CategoryBuilder {

  private Integer categoryId;
  private String categoryName;
  private ParentCategory parentCategory;

  public static CategoryBuilder builder() {
    return new CategoryBuilder();
  }

  public CategoryBuilder withCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  public CategoryBuilder withCategoryName(String categoryName) {
    this.categoryName = categoryName;
    return this;
  }

  public CategoryBuilder withParentCategory(ParentCategory parentCategory) {
    this.parentCategory = parentCategory;
    return this;
  }

  public Category build() {
    return new Category(categoryId, categoryName, parentCategory);
  }

  public Category buildCategoryWithGeneratedId(CategoryBody categoryBody, int id) {
    return CategoryBuilder
        .builder()
        .withCategoryId(id)
        .withCategoryName(categoryBody.getCategoryName())
        .withParentCategory(categoryBody.getParentCategory())
        .build();
  }

}
