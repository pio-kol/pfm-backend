package pl.pfm.model.parentcategory;

public class ParentCategoryBuilder {

  private Integer parentCategoryId;
  private String parentCategoryName;

  public static ParentCategoryBuilder builder() {
    return new ParentCategoryBuilder();
  }

  public ParentCategoryBuilder withParentCategoryId(Integer id) {
    this.parentCategoryId = id;
    return this;
  }

  public ParentCategoryBuilder withParentCategoryName(String parentCategoryName) {
    this.parentCategoryName = parentCategoryName;
    return this;
  }

  public ParentCategory build() {
    return new ParentCategory(parentCategoryId, parentCategoryName);
  }

}
