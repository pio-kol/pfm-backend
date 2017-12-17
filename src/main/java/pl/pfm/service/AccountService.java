package pl.pfm.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import pl.pfm.model.account.Account;
import pl.pfm.model.account.AccountBody;
import pl.pfm.model.account.AccountBuilder;
import pl.pfm.repository.AccountRepository;

import java.util.Iterator;
import java.util.List;

@Service
public class AccountService {

  @Resource
  private AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public List<Account> getAccounts() {
    return accountRepository.findAll();
  }

  public Account getOneAccount(long id) {
    return accountRepository.findOne(id);
  }

  public void postAccount(AccountBody accountBody) {
    accountRepository.save(accountBody);
  }

  public boolean deleteAccount(long id) {
    return accountRepository.delete(id);
  }

  public void putAccount(long id, AccountBody accountBody) {
    Iterator<Account> accountIterator = accountRepository.findAll().iterator();
    while (accountIterator.hasNext()) {
      if (accountIterator.next().getId() == id) {
        accountIterator.remove();
        Account account = AccountBuilder
            .builder()
            .buildAccountWithId(id, accountBody);
        accountRepository.save(account);
      }
    }
  }
}