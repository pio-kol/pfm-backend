package pl.pfm.model.parentcategory;

public class ParentCategoryBuilder {

  private long parentCategoryId;
  private String parentCategoryName;

  public static ParentCategoryBuilder builder() {
    return new ParentCategoryBuilder();
  }

  public ParentCategoryBuilder withParentCategoryId(long id) {
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

  public ParentCategory buildParentCategoryWithoutId(ParentCategoryBody parentCategoryBody) {
    return ParentCategoryBuilder
        .builder()
        .withParentCategoryName(parentCategoryBody.getParentCategoryName())
        .build();
  }

  public ParentCategory buildParentCategoryWithId(long id, ParentCategoryBody parentCategoryBody) {
    return ParentCategoryBuilder
        .builder()
        .withParentCategoryId(id)
        .withParentCategoryName(parentCategoryBody.getParentCategoryName())
        .build();
  }

}
