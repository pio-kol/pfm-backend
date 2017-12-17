package pl.pfm.controller;

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
  @GetMapping(value = "/{id}")
  public Transaction getOneTransaction(@PathVariable long id) {
    return transactionService.getOneTransaction(id);
  }

  @CrossOrigin
  @PostMapping
  public long postTransaction(@RequestBody TransactionBody transactionBody) throws IOException {
    return transactionService.postTransaction(transactionBody);
  }

  @CrossOrigin
  @PutMapping(value = "/{id}")
  public void putTransaction(@PathVariable long id, @RequestBody TransactionBody transactionBody) {
    transactionService.putTransaction(id, transactionBody);
  }

  @CrossOrigin
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> deleteTransaction(long id) {
    return (transactionService.deleteTransaction(id) ?
        ResponseEntity.ok() : ResponseEntity.notFound()).build();
  }
}
