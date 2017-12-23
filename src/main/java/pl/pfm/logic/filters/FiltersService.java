package pl.pfm.logic.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pfm.logic.accounts.AccountRepository;
import pl.pfm.logic.categories.CategoryRepository;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;
import pl.pfm.model.filter.Filter;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiltersService {

    private FiltersRepository filtersRepository;
    private CategoryRepository categoryRepository;
    private AccountRepository accountRepository;

    public List<Filter> getFilters() {
        return filtersRepository.findAll();
    }

    public Filter getOneFilter(long id) {
        return filtersRepository.findOne(id);
    }

    public long postFilter(Filter filterBody) {
        Filter filter = Filter.builder()
                .accounts(filterBody.getAccounts().stream().map(account -> accountRepository.findOne(account.getId())).collect(Collectors.toList()))
                .categories(filterBody.getCategories().stream().map(category -> categoryRepository.findOne(category.getId())).collect(Collectors.toList()))
                .comment(filterBody.getComment())
                .dateFrom(filterBody.getDateFrom())
                .dateTo(filterBody.getDateTo())
                .description(filterBody.getDescription())
                .name(filterBody.getName())
                .priceFrom(filterBody.getPriceFrom())
                .priceTo(filterBody.getPriceTo())
                .build();


        filtersRepository.save(filter);
        return filter.getId();
    }

    public boolean deleteFilter(long id) {
        filtersRepository.delete(id);
        return filtersRepository.findOne(id) == null;
    }

    public Filter putFilter(long id, Filter filterBody) {
        Filter filterToUpdate = filtersRepository.findOne(id);

        filterToUpdate.setAccounts(filterBody.getAccounts().stream().map(account -> accountRepository.findOne(account.getId())).collect(Collectors.toList()));
        filterToUpdate.setCategories(filterBody.getCategories().stream().map(category -> categoryRepository.findOne(category.getId())).collect(Collectors.toList()));
        filterToUpdate.setComment(filterBody.getComment());
        filterToUpdate.setDateFrom(filterBody.getDateFrom());
        filterToUpdate.setDateTo(filterBody.getDateTo());
        filterToUpdate.setDescription(filterBody.getDescription());
        filterToUpdate.setName(filterBody.getName());
        filterToUpdate.setPriceFrom(filterBody.getPriceFrom());
        filterToUpdate.setPriceTo(filterBody.getPriceTo());

        filtersRepository.save(filterToUpdate);

        return filterToUpdate;
    }

    @Autowired
    public void setFiltersRepository(FiltersRepository filtersRepository) {
        this.filtersRepository = filtersRepository;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
