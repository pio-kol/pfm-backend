package pl.pfm.database;

import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;

import java.util.List;

/**
 * Interface Database - provides methods to save and get transactions from database.
 */
public interface Database {

  void saveTransaction(Transaction transaction);

  void removeTransaction(Transaction transaction);

  List<Transaction> getTransactions();

  Transaction createTransaction(TransactionBody transactionBody);

  Integer getNextTransactionId();
}
