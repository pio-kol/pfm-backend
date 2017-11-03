package pl.pfm.categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pfm.model.category.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}





