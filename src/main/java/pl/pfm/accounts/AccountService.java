package pl.pfm.accounts;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import pl.pfm.model.account.Account;
import pl.pfm.model.account.AccountBody;
import pl.pfm.model.account.AccountBuilder;

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

  public long postAccount(AccountBody accountBody) {
    Account account = AccountBuilder.builder()
        .buildAccountWithoutId(accountBody);
    Account createdAccount = accountRepository.save(account);
    return createdAccount.getId();
  }

  public boolean deleteAccount(long id) {
    accountRepository.delete(id);
    return accountRepository.getOne(id) == null;

  }

  public void putAccount(long id, AccountBody accountBody) {
    Iterator<Account> accountIterator = accountRepository.findAll().iterator();
    Account account = null;
    while (accountIterator.hasNext()) {
      if (accountIterator.next().getId() == id) {
        accountIterator.remove();
        account = AccountBuilder
            .builder()
            .buildAccountWithId(id, accountBody);
      }
    }
    if (account != null) {
      accountRepository.save(account);
    }
  }
}
