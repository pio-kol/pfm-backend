package pl.pfm.model.account;

import java.math.BigDecimal;

public class AccountBuilder {

  private long accountId;
  private String accountName;
  private BigDecimal accountState;


  public static AccountBuilder builder() {
    return new AccountBuilder();
  }

  public AccountBuilder withAccountId(long accountId) {
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

  public Account buildAccountWithId(long id, AccountBody accountBody) {
    return AccountBuilder
        .builder()
        .withAccountId(id)
        .withAccountName(accountBody.getAccountName())
        .withAccountState(accountBody.getAccountState())
        .build();
  }
}
