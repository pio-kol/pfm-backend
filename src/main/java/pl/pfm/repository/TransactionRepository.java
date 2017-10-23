package pl.pfm.repository;

import org.springframework.stereotype.Service;
import pl.pfm.database.Database;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;
import pl.pfm.model.transaction.TransactionBuilder;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TransactionRepository {

  private List<Transaction> transactions;
  private AtomicInteger nextId = new AtomicInteger(1);

  public TransactionRepository(Database database) {
    this.transactions = database.getTransactions();

  }

  public void save(Transaction transaction) {
    transactions.add(transaction);
  }

  public void save(TransactionBody transactionBody) {
    Transaction transaction = TransactionBuilder
        .builder()
        .buildTransactionWithGeneratedId(transactionBody, getNextId());
    transactions.add(transaction);

  }

  public List<Transaction> findAll() {
    return transactions;

  }

  public long count() {
    return transactions.size();
  }

  public Transaction getOneById(Integer id) {
    return transactions
        .stream()
        .filter(t1 -> t1.getId().equals(id))
        .findAny()
        .orElse(null);
  }

  public void delete(Transaction transaction) {
    transactions.remove(transaction);

  }

  public void delete(Integer id) {
    Transaction transaction = getOneById(id);
    transactions.remove(transactions.indexOf(transaction));
  }

  private int getNextId() {
    return nextId.getAndIncrement();
  }


}
