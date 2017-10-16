package pl.pfm.model.account;

import java.math.BigDecimal;

public class Account {

  private Integer accountId;
  private String accountName;
  private BigDecimal accountState;

  public Account() {
  }

  public Account(Integer accountId, String accountName, BigDecimal accountState) {
    this.accountId = accountId;
    this.accountName = accountName;
    this.accountState = accountState;
  }

  public Integer getAccountId() {
    return accountId;
  }

  public String getAccountName() {
    return accountName;
  }

  public BigDecimal getAccountState() {
    return accountState;
  }

}
