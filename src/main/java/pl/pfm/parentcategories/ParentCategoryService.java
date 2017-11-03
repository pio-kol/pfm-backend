package pl.pfm.parentcategories;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import pl.pfm.model.parentcategory.ParentCategory;
import pl.pfm.model.parentcategory.ParentCategoryBody;
import pl.pfm.model.parentcategory.ParentCategoryBuilder;

import java.util.Iterator;
import java.util.List;

@Service
public class ParentCategoryService {

  @Resource
  private ParentCategoryRepository parentCategoryRepository;

  public ParentCategoryService(ParentCategoryRepository parentCategoryRepository) {
    this.parentCategoryRepository = parentCategoryRepository;
  }

  public List<ParentCategory> getParentCategories() {
    return parentCategoryRepository.findAll();
  }

  public ParentCategory getOneParentCategory(long id) {
    return parentCategoryRepository.findOne(id);
  }

  public long postParentCategory(ParentCategoryBody parentCategoryBody) {
    ParentCategory createdParentCategory = ParentCategoryBuilder
        .builder()
        .buildParentCategoryWithoutId(parentCategoryBody);
    parentCategoryRepository.save(createdParentCategory);
    return createdParentCategory.getParentCategoryId();
  }

  public boolean deleteParentCategory(long id) {
    parentCategoryRepository.delete(id);
    return parentCategoryRepository.findOne(id) == null;
  }

  public void putParentCategory(long id, ParentCategoryBody parentCategoryBody) {
    Iterator<ParentCategory> parentCategoryIterator =
        parentCategoryRepository.findAll().iterator();
    ParentCategory parentCategory = null;
    while (parentCategoryIterator.hasNext()) {
      if (parentCategoryIterator.next().getParentCategoryId() == id) {
        parentCategoryIterator.remove();
        parentCategory = ParentCategoryBuilder
            .builder()
            .buildParentCategoryWithId(id, parentCategoryBody);
      }
    }
    if (parentCategory != null) {
      parentCategoryRepository.save(parentCategory);
    }

  }
}
