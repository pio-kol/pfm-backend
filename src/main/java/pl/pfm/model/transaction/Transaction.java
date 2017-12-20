package pl.pfm.model.transaction;

import lombok.Builder;
import lombok.Data;
import pl.pfm.model.account.Account;
import pl.pfm.model.category.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Transaction
 */
@Data
@Builder
public class Transaction {

  private long id;
  private LocalDate date;
  private String description;
  private String comment;
  private Category category;
  private Account account;
  private BigDecimal price;

  /**
   * @param id - transaction id.
   * @param date - date of transaction.
   * @param description - of transaction.
   * @param category - of transaction.
   * @param account - transaction if from.
   * @param price - of transaction.
   */


}


