package pl.pfm.logic.accounts;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pfm.model.account.Account;
import pl.pfm.model.account.AccountBody;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

  private AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @CrossOrigin
  @GetMapping(value = "/")
  public List<Account> getAccounts() {
    return accountService.getAccounts();
  }

  @CrossOrigin
  @GetMapping(value = "/{id}")
  public Account getOneAccount(@PathVariable long id) {
    return accountService.getOneAccount(id);
  }

  @CrossOrigin
  @PostMapping
  public long postAccount(@RequestBody AccountBody accountBody) throws IOException {
    return accountService.postAccount(accountBody);
  }

  @CrossOrigin
  @PutMapping(value = "/{id}")
  public void putAccount(@PathVariable long id, @RequestBody AccountBody accountBody) {
    accountService.putAccount(id, accountBody);
  }

  @CrossOrigin
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> deleteAccount(@PathVariable long id) {
    return (accountService.deleteAccount(id) ?
        ResponseEntity.ok() : ResponseEntity.notFound()).build();
  }


}
