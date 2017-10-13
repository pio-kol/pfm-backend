package pl.pfm.model.account;

public class AccountBuilder {

  private Integer accountId;
  private String bankName;

  public static AccountBuilder builder() {
    return new AccountBuilder();
  }

  public AccountBuilder withAccountId(Integer accountId) {
    this.accountId = accountId;
    return this;
  }

  public AccountBuilder withBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public Account build() {
    return new Account(accountId, bankName);
  }
}
