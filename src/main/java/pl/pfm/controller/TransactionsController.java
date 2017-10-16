package pl.pfm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pfm.model.account.AccountBuilder;
import pl.pfm.model.category.CategoryBuilder;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;
import pl.pfm.model.transaction.TransactionBuilder;
import pl.pfm.service.TransactionsService;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/transactions")
public class TransactionsController {

  private final TransactionsService service;

  public TransactionsController(TransactionsService service) {
    this.service = service;
  }


  @GetMapping(value = "/{id}")
  public Transaction getSingleTransaction(@PathVariable("id") int id) {
    return service.getTransaction(id);
  }

  @CrossOrigin
  @GetMapping(value = "/")
  public List<Transaction> getTransactions() {

    Transaction t1 = TransactionBuilder
        .builder()
        .withId(1)
        .withDate(LocalDate.now())
        .withDescription("My new computer")
        .withComment("My first comment")
        .withCategory(CategoryBuilder.builder()
            .withCategoryId(1))
        .withAccount(AccountBuilder.builder()
            .withAccountId(1)
            .withAccountName("Idea"))
        .withPrice(BigDecimal.ONE)
        .build();

    Transaction t2 = TransactionBuilder
        .builder()
        .withId(2)
        .withDate(LocalDate.now())
        .withDescription("My new computer 2")
        .withComment("My first comment 2")
        .withCategory(CategoryBuilder.builder()
            .withCategoryId(1))
        .withAccount(AccountBuilder.builder()
            .withAccountId(1)
            .withAccountName("Idea"))
        .withPrice(BigDecimal.ONE)
        .build();

    return Arrays.asList(t1, t2);
  }


  @PostMapping
  public int postTransaction(@RequestBody TransactionBody transactionBody) throws IOException {
    return service.postTransaction(transactionBody);
  }

}
