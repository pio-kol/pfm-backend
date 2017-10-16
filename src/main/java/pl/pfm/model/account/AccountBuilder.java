package pl.pfm.model.account;

import java.math.BigDecimal;

public class AccountBuilder {

  private Integer accountId;
  private String accountName;
  private BigDecimal accountState;


  public static AccountBuilder builder() {
    return new AccountBuilder();
  }

  public AccountBuilder withAccountId(Integer accountId) {
    this.accountId = accountId;
    return this;
  }

  public AccountBuilder withAccountName(String accountName) {
    this.accountName = accountName;
    return this;
  }

  public AccountBuilder withAccountState(BigDecimal accountState) {
    this.accountState = accountState;
    return this;
  }

  public Account build() {
    return new Account(accountId, accountName, accountState);
  }

  public Account buildAccountWithGeneratedId(AccountBody accountBody, int id) {
    return AccountBuilder
        .builder()
        .withAccountId(id)
        .withAccountName(accountBody.getAccountName())
        .withAccountState(accountBody.getAccountState())
        .build();
  }
}
