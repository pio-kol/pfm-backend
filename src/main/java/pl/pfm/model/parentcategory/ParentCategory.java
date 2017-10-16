package pl.pfm.model.parentcategory;

public class ParentCategory {

  private Integer parentCategoryId;
  private String parentCategoryName;

  public ParentCategory() {
  }

  public ParentCategory(Integer parentCategoryId, String parentCategoryName) {
    this.parentCategoryId = parentCategoryId;
    this.parentCategoryName = parentCategoryName;
  }

  public Integer getParentCategoryId() {
    return parentCategoryId;
  }

  public String getParentCategoryName() {
    return parentCategoryName;
  }
}
