package pl.pfm.model.transactions;

import org.springframework.stereotype.Service;
import pl.pfm.database.Database;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;

import java.io.IOException;
import java.util.List;

@Service
public class Transactions {

  private final Database database;

  public Transactions(Database database) {
    this.database = database;
  }

  public void addTransaction(Transaction transaction) {
    database.saveTransaction(transaction);
  }

  public List<Transaction> getTransactions() throws IOException {
    return database.getTransactions();
  }


  public Transaction getTransactionById(Integer id) {
    return database.getTransactions()
        .stream()
        .filter(transaction -> transaction.getId().equals(id))
        .findAny()
        .orElse(null);
  }

  public void removeTransactions(Integer id) {
    Transaction foundTransaction = getTransactionById(id);
    database.removeTransaction(foundTransaction);
  }

  public Transaction createTransation(TransactionBody transactionBody) {
    return database.createTransaction(transactionBody);
  }

  public Integer getNextTransactionId(){
    return database.getNextTransactionId();
  }

  @Override
  public String toString() {
    return "Transactions{" +
        "database=" + database +
        '}';
  }

}



