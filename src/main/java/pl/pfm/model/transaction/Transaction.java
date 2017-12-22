package pl.pfm.model.transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Entity
public class Transaction implements Comparable<Transaction> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private LocalDate date;
  private String description;
  private String comment;
  @ManyToOne
  private Category category;
  @ManyToOne
  private Account account;
  private BigDecimal price;

  public Transaction() {
  }

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


