package pl.pfm.model.account;

public class Account {

  private Integer accountId;
  private String bankName;

  Account(Integer accountId, String bankName) {
    this.accountId = accountId;
    this.bankName = bankName;
  }

  public Integer getAccountId() {
    return accountId;
  }

  public String getBankName() {
    return bankName;
  }
}
