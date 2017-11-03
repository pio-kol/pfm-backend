package pl.pfm.model.parentcategory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParentCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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

