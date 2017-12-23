package pl.pfm.model.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pfm.model.account.Account;
import pl.pfm.model.category.Category;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Filter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany
    private List<Category> categories;

    @OneToMany
    private List<Account> accounts;

    private LocalDate dateFrom;
    private LocalDate dateTo;

    private BigDecimal priceFrom;
    private BigDecimal priceTo;

    private String description;
    private String comment;


}
