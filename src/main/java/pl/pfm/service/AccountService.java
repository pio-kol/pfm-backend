package pl.pfm.service;

import javax.annotation.Resource;
import pl.pfm.model.account.Account;
import pl.pfm.model.account.AccountBody;
import pl.pfm.model.account.AccountBuilder;
import pl.pfm.model.accounts.Accounts;

public class AccountService {

  @Resource
  private final Accounts accounts;

  public AccountService(Accounts accounts) {
    this.accounts = accounts;
  }

  public Account getAccount(Integer id) {
    return accounts.getAccountById(id);
  }

  public int postAccount(AccountBody accountBody) {
    Account account = createAccount(accountBody);
    accounts.addAccount(account);
    return account.getAccountId();
  }

  private Account createAccount(AccountBody accountBody) {
    return AccountBuilder
        .builder()
        .withAccountId(accounts.getNextAccountId())
        .withAccountName(accountBody.getAccountName())
        .withAccountState(accountBody.getAccountState())
        .build();
  }

}
