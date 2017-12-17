package pl.pfm.database;

import pl.pfm.model.account.Account;
import pl.pfm.model.account.AccountBody;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;

import java.util.List;

public interface Database {

  long saveTransaction(TransactionBody transactionBody);

  long saveTransaction(Transaction transaction);

  List<Transaction> findAllTransactions();

  boolean deleteTransaction(long id);

  long saveAccount(AccountBody accountBody);

  long saveAccount(Account account);

  List<Account> findAllAccounts();

  boolean deleteAccount(long id);

  long saveCategory(CategoryBody categoryBody);

  long saveCategory(Category category);

  List<Category> findAllCategories();

  boolean deleteCategory(long id);

}
