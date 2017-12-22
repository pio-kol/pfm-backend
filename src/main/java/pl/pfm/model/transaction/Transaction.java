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
public class Transaction implements Comparable<Transaction>{

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

  @Override
  public int compareTo(pl.pfm.model.transaction.Transaction transaction) {

      if (transaction == null) {
          return -1;
      }
      if (this == null) {
          return -1;
      }
      if(this.getId() == transaction.getId()){
          return 0;
      }
      return this.getId() < transaction.getId()? -1 : 1;
  }
}


