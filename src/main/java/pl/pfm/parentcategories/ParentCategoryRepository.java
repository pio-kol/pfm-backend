package pl.pfm.parentcategories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pfm.model.parentcategory.ParentCategory;

@Repository
public interface ParentCategoryRepository extends JpaRepository<ParentCategory, Long> {

}
