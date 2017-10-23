package pl.pfm.database;

import pl.pfm.model.account.Account;
import pl.pfm.model.category.Category;
import pl.pfm.model.transaction.Transaction;

import java.util.List;

public interface Database {

  public List<Transaction> getTransactions() ;

  public List<Account> getAccounts();

  public List<Category> getCategories() ;


}
