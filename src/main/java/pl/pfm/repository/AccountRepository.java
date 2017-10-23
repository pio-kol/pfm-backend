package pl.pfm.repository;

import org.springframework.stereotype.Service;
import pl.pfm.database.Database;
import pl.pfm.model.account.Account;
import pl.pfm.model.account.AccountBody;
import pl.pfm.model.account.AccountBuilder;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AccountRepository {

  private List<Account> accounts;
  AtomicInteger nextId = new AtomicInteger(1);

  public AccountRepository(Database database) {
    this.accounts = database.getAccounts();
  }

  public void save(Account account) {
    accounts.add(account);
  }

  public void save(AccountBody accountBody) {
    Account account = AccountBuilder
        .builder()
        .buildAccountWithGeneratedId(accountBody, getNextId());
    accounts.add(account);

  }

  public List<Account> findAll() {
    return accounts;

  }

  public long count() {
    return accounts.size();
  }

  public Account getOneById(Integer id) {
    return accounts
        .stream()
        .filter(a1 -> a1.getId().equals(id))
        .findAny()
        .orElse(null);
  }

  public void delete(Account account) {
    accounts.remove(account);

  }

  public void delete(Integer id) {
    Account account = getOneById(id);
    accounts.remove(accounts.indexOf(account));
  }

  private int getNextId() {
    return nextId.getAndIncrement();
  }
}
