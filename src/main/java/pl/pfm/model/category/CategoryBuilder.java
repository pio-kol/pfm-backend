package pl.pfm.model.category;

public class CategoryBuilder {

  private Integer categoryId;

  public static CategoryBuilder builder() {
    return new CategoryBuilder();
  }

  public CategoryBuilder withCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  public Category build() {
    return new Category(categoryId);
  }

}
