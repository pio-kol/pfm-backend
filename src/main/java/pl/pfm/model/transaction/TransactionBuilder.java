package pl.pfm.model.transaction;

import pl.pfm.model.account.Account;
import pl.pfm.model.account.AccountBuilder;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionBuilder {

  private long id;
  private LocalDate date;
  private String description;
  private String comment;
  private Category category;
  private Account account;
  private BigDecimal price;

  public static TransactionBuilder builder() {
    return new TransactionBuilder();
  }

  public TransactionBuilder withId(long id) {
    this.id = id;
    return this;
  }

  public TransactionBuilder withDate(LocalDate date) {
    this.date = date;
    return this;
  }

  public TransactionBuilder withDescription(String description) {
    this.description = description;
    return this;
  }

  public TransactionBuilder withComment(String comment) {
    this.comment = comment;
    return this;
  }

  public TransactionBuilder withCategory(Category category) {
    this.category = category;
    return this;
  }

  public TransactionBuilder withCategory(CategoryBuilder categoryBuilder) {
    this.category = categoryBuilder.build();
    return this;
  }

  public TransactionBuilder withAccount(Account account) {
    this.account = account;
    return this;
  }

  public TransactionBuilder withAccount(AccountBuilder accountBuilder) {
    this.account = accountBuilder.build();
    return this;
  }

  public TransactionBuilder withPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public Transaction build() {
    return new Transaction(id, date, description, comment,
        category, account, price);
  }

  public Transaction buildTransactionWithId(long id, TransactionBody transactionBody) {
    return TransactionBuilder
        .builder()
        .withId(id)
        .withDate(transactionBody.getDate())
        .withDescription(transactionBody.getDescription())
        .withComment(transactionBody.getComment())
        .withCategory(transactionBody.getCategory())
        .withAccount(transactionBody.getAccount())
        .withPrice(transactionBody.getPrice())
        .build();
  }

  public Transaction buildTransactionWithoutId(TransactionBody transactionBody) {
    return TransactionBuilder
        .builder()
        .withDate(transactionBody.getDate())
        .withDescription(transactionBody.getDescription())
        .withComment(transactionBody.getComment())
        .withCategory(transactionBody.getCategory())
        .withAccount(transactionBody.getAccount())
        .withPrice(transactionBody.getPrice())
        .build();
  }

}



