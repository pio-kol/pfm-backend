package pl.pfm.model.transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import pl.pfm.model.account.Account;
import pl.pfm.model.category.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Transaction
 */
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


  public Transaction(long id, LocalDate date, String description, String comment,
      Category category, Account account, BigDecimal price) {
    this.id = id;
    this.date = date;
    this.description = description;
    this.comment = comment;
    this.category = category;
    this.account = account;
    this.price = price;
  }

  public long getId() {
    return id;
  }

  public LocalDate getDate() {
    return date;
  }

  public String getDescription() {
    return description;
  }

  public String getComment() {
    return comment;
  }

  public Category getCategory() {
    return category;
  }

  public Account getAccount() {
    return account;
  }

  public BigDecimal getPrice() {
    return price;
  }


  @Override
  public int compareTo(Transaction transaction) {

    if (transaction == null) {
      return -1;
    }
    if (this == null) {
      return -1;
    }
    if (this.getId() == transaction.getId()) {
      return 0;
    }
    return this.getId() < transaction.getId() ? -1 : 1;
  }

}


