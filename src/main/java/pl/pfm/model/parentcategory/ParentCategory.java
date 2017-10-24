package pl.pfm.model.parentcategory;

public class ParentCategory {

  private long parentCategoryId;
  private String parentCategoryName;

  public ParentCategory() {
  }

  public ParentCategory(long parentCategoryId, String parentCategoryName) {
    this.parentCategoryId = parentCategoryId;
    this.parentCategoryName = parentCategoryName;
  }

  public long getParentCategoryId() {
    return parentCategoryId;
  }

  public String getName() {
    return parentCategoryName;
  }
}

