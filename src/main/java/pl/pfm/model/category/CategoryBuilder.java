package pl.pfm.model.category;

import pl.pfm.model.parentcategory.ParentCategory;

public class CategoryBuilder {

  private long categoryId;
  private String categoryName;
  private ParentCategory parentCategory;

  public static CategoryBuilder builder() {
    return new CategoryBuilder();
  }

  public CategoryBuilder withCategoryId(long categoryId) {
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

  public Category buildCategoryWithId(long id, CategoryBody categoryBody) {
    return CategoryBuilder
        .builder()
        .withCategoryId(id)
        .withCategoryName(categoryBody.getCategoryName())
        .withParentCategory(categoryBody.getParentCategory())
        .build();
  }

  public Category buildCategoryWithoutId(CategoryBody categoryBody) {
    return CategoryBuilder
        .builder()
        .withCategoryName(categoryBody.getCategoryName())
        .withParentCategory(categoryBody.getParentCategory())
        .build();
  }

}
