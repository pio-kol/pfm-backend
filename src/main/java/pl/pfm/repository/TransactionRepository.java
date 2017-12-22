package pl.pfm.repository;

import org.springframework.stereotype.Service;
import pl.pfm.database.Database;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;

import java.util.List;

@Service
public class TransactionRepository {

  Database database;

  public TransactionRepository(Database database) {
    this.database = database;
  }

  public long save(TransactionBody transactionBody) {
    return database.saveTransaction(transactionBody);
  }

  public void save(Transaction transaction) {
    database.saveTransaction(transaction);
  }

  public List<Transaction> findAll() {
    return database.findAllTransactions();
  }

  public Transaction findOne(long id) {
    return database.findAllTransactions()
        .stream()
        .filter(t1 -> t1.getId() == id)
        .findAny()
        .orElse(null);
  }

  public boolean delete(long id) {
    return database.deleteTransaction(id);
  }


}
