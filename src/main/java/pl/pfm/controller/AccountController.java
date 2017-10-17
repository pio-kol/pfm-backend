package pl.pfm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pfm.model.account.Account;
import pl.pfm.model.account.AccountBody;
import pl.pfm.model.account.AccountBuilder;
import pl.pfm.service.AccountService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

  private final AccountService service;

  public AccountController(AccountService service) {
    this.service = service;
  }


  @GetMapping(value = "/{id}")
  public Account getSingleAccount(@PathVariable("id") int id) {
    return service.getAccount(id);
  }

  @CrossOrigin
  @GetMapping(value = "/")
  public List<Account> getAccounts() {

    Account a1 = AccountBuilder
        .builder()
        .withAccountId(1)
        .withAccountName("mBank")
        .withAccountState(BigDecimal.valueOf(123.16))
        .build();

    Account a2 = AccountBuilder
        .builder()
        .withAccountId(1)
        .withAccountName("Inteligo")
        .withAccountState(BigDecimal.valueOf(234.56))
        .build();

    return Arrays.asList(a1, a2);
  }


  @PostMapping
  public int postAccount(@RequestBody AccountBody accountBody) throws IOException {
    return service.postAccount(accountBody);
  }

}
