package pl.pfm.logic.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/transactions")
public class TransactionController {

    private TransactionService transactionService;

    @CrossOrigin
    @GetMapping(value = "/")
    public List<Transaction> getTransactions() {
        return transactionService.getTransactions().stream().sorted().collect(Collectors.toList());
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
    public Transaction putTransaction(@PathVariable long id, @RequestBody TransactionBody transactionBody) {
        return transactionService.putTransaction(id, transactionBody);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable long id) {
        return (transactionService.deleteTransaction(id) ?
                ResponseEntity.ok() : ResponseEntity.notFound()).build();
    }

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
}
