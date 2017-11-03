package pl.pfm.model.category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import pl.pfm.model.parentcategory.ParentCategory;

@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  @ManyToOne
  private ParentCategory parentCategory;

  public Category() {
  }

  public Category(long id, String name, ParentCategory parentCategory) {
    this.id = id;
    this.name = name;
    this.parentCategory = parentCategory;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public ParentCategory getParentCategory() {
    return parentCategory;
  }
}
