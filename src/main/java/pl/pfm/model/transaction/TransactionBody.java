package pl.pfm.model.transaction;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.pfm.model.account.Account;
import pl.pfm.model.category.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionBody {
  private LocalDate date = LocalDate.now();
  private String description;
  private String comment;
  private Category category;
  private Account account;
  private BigDecimal price;

  public TransactionBody(){
  }
  @JsonCreator
  public TransactionBody(@JsonProperty("date") LocalDate date,
      @JsonProperty("description") String description, @JsonProperty("comment") String comment,
      @JsonProperty("category") Category category, @JsonProperty("account") Account account,
      @JsonProperty("price") BigDecimal price) {
    this.date = date;
    this.description = description;
    this.comment = comment;
    this.category = category;
    this.account = account;
    this.price = price;
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
}
