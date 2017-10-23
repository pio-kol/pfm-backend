package pl.pfm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pfm.model.account.Account;
import pl.pfm.model.account.AccountBody;
import pl.pfm.service.AccountService;

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
  @PostMapping
  public void postAccount(@RequestBody AccountBody accountBody) throws IOException {
    accountService.addAccount(accountBody);
  }

}
