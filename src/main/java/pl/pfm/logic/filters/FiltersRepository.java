package pl.pfm.logic.filters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pfm.model.category.Category;
import pl.pfm.model.filter.Filter;

@Repository
public interface FiltersRepository extends JpaRepository<Filter, Long> {

}





