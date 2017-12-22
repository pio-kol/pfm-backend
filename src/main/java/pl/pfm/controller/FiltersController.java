package pl.pfm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pfm.model.filter.Filter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/filters")
public class FiltersController {

    @CrossOrigin
    @GetMapping(value = "/")
    public List<Filter> getFilters() {

        Filter filter1 = new Filter();
        filter1.setAccounts(new ArrayList<>());
        filter1.setCategories(new ArrayList<>());
        filter1.setComment("");
        filter1.setDateFrom(LocalDate.of(2017, 1, 1));
        filter1.setDateTo(LocalDate.of(2017, 12, 31));
        filter1.setDescription("");
        filter1.setName("This Year");
        filter1.setPriceFrom(BigDecimal.ZERO);
        filter1.setPriceTo(BigDecimal.valueOf(1111111));

        Filter filter2 = new Filter();
        filter2.setName("Empty");

        return Arrays.asList(filter2, filter1);
    }

}
