package pl.pfm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;
import pl.pfm.service.TransactionsService;

import java.io.IOException;

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


  @PostMapping
  public int postInvoice(@RequestBody TransactionBody transactionBody) throws IOException {
    return service.postTransaction(transactionBody);
  }

}
