package pl.pfm.logic.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pfm.logic.accounts.AccountService;
import pl.pfm.logic.categories.CategoryService;
import pl.pfm.model.filter.Filter;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/filters")
public class FiltersController {

    private FiltersService filtersService;

    @CrossOrigin
    @GetMapping(value = "/")
    public List<Filter> getFilters() {
        return filtersService.getFilters();
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public Filter getOneFilter(@PathVariable long id) {
        return filtersService.getOneFilter(id);
    }

    @CrossOrigin
    @PostMapping
    public long postTransaction(@RequestBody Filter filter) throws IOException {
        return filtersService.postFilter(filter);

    }

    @CrossOrigin
    @PutMapping(value = "/{id}")
    public Filter putTransaction(@PathVariable long id, @RequestBody Filter filterBody) {
        return filtersService.putFilter(id, filterBody);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteFilter(@PathVariable long id) {
        return (filtersService.deleteFilter(id) ?
                ResponseEntity.ok() : ResponseEntity.notFound()).build();
    }

    @Autowired
    public void setFiltersService(FiltersService filtersService) {
        this.filtersService = filtersService;
    }

}
