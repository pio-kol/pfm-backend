package pl.pfm.repository;

import org.springframework.stereotype.Service;
import pl.pfm.database.Database;
import pl.pfm.model.account.Account;
import pl.pfm.model.account.AccountBody;

import java.util.List;

@Service
public class AccountRepository {

  Database database;

  public AccountRepository(Database database) {
    this.database = database;
  }

  public void save(AccountBody accountBody) {
    database.saveAccount(accountBody);
  }

  public void save(Account account) {
    database.saveAccount(account);
  }

  public List<Account> findAll() {
    return database.findAllAccounts();
  }

  public Account findOne(long id) {
    return database.findAllAccounts()
        .stream()
        .filter(a -> a.getId() == id)
        .findAny()
        .orElse(null);
  }

  public boolean delete(long id) {
    return database.deleteAccount(id);
  }


}
