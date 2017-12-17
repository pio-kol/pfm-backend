package pl.pfm.model.account;

import java.math.BigDecimal;

public class Account {

  private long id;
  private String name;
  private BigDecimal value;

  public Account() {
  }

  public Account(long accountId, String accountName, BigDecimal value) {
    this.id = accountId;
    this.name = accountName;
    this.value = value;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getValue() {
    return value;
  }
}
