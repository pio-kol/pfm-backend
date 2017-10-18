package pl.pfm.model.account;

import java.math.BigDecimal;

public class Account {

  private Integer id;
  private String name;
  private BigDecimal value;

  public Account() {
  }

  public Account(Integer accountId, String accountName, BigDecimal value) {
    this.id = accountId;
    this.name = accountName;
    this.value = value;
  }

  public Integer getAccountId() {
    return id;
  }

  public String getAccountName() {
    return name;
  }

  public BigDecimal getAccountState() {
    return value;
  }

}
