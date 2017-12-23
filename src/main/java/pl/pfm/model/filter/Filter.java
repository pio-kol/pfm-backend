package pl.pfm.model.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Filter {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private List<Integer> categories;
    private List<Integer> accounts;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private BigDecimal priceFrom;
    private BigDecimal priceTo;
    private String description;
    private String comment;


}
