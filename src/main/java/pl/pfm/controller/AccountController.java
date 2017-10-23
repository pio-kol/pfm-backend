package pl.pfm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pfm.model.account.Account;
import pl.pfm.model.account.AccountBuilder;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

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

}
