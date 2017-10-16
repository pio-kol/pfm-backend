package pl.pfm.database;


import pl.pfm.model.account.Account;
import pl.pfm.model.account.AccountBody;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;

import java.util.List;

/**
 * Interface Database - provides methods to save and get transactions from database.
 */
public interface Database {

  //Transaction
  void saveTransaction(Transaction transaction);

  void removeTransaction(Transaction transaction);

  List<Transaction> getTransactions();

  Transaction createTransaction(TransactionBody transactionBody);

  Integer getNextTransactionId();

  //Category
  void saveCategory(Category category);

  void removeCategory(Category category);

  List<Category> getCategories();

  Category createCategory(CategoryBody categoryBody);

  Integer getNextCategoryId();

  //Account
  void saveAccount(Account account);

  void removeAccount(Account account);

  List<Account> getAccounts();

  Account createAccount(AccountBody accountBody);

  Integer getNextAccountId();
}
