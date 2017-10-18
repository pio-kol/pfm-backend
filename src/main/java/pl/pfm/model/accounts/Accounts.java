package pl.pfm.model.accounts;

import org.springframework.stereotype.Service;
import pl.pfm.database.Database;
import pl.pfm.model.account.Account;
import pl.pfm.model.account.AccountBody;

import java.io.IOException;
import java.util.List;

@Service
public class Accounts {

  private final Database database;

  public Accounts(Database database) {
    this.database = database;
  }

  public void addAccount(Account account) {
    database.saveAccount(account);
  }

  public List<Account> getAccounts() throws IOException {
    return database.getAccounts();
  }


  public Account getAccountById(Integer id) {
    return database.getAccounts()
        .stream()
        .filter(account -> account.getId().equals(id))
        .findAny()
        .orElse(null);
  }

  public void removeAccount(Integer id) {
    Account foundAccount = getAccountById(id);
    database.removeAccount(foundAccount);
  }

  public Account createAccount(AccountBody accountBody) {
    return database.createAccount(accountBody);
  }

  public Integer getNextAccountId() {
    return database.getNextTransactionId();
  }

}
