package pl.pfm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;
import pl.pfm.service.TransactionService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/transactions")
public class TransactionController {

  private TransactionService transactionService;

  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @CrossOrigin
  @GetMapping(value = "/")
  public List<Transaction> getTransactions() {
    return transactionService.getTransactions();
  }

  @CrossOrigin
  @PostMapping
  public void postTransaction(@RequestBody TransactionBody transactionBody) throws IOException {
    transactionService.addTransaction(transactionBody);
  }

}
