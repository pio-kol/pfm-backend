package pl.pfm.database.impl;


import org.springframework.stereotype.Service;
import pl.pfm.database.Database;
import pl.pfm.model.account.Account;
import pl.pfm.model.account.AccountBody;
import pl.pfm.model.account.AccountBuilder;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;
import pl.pfm.model.category.CategoryBuilder;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;
import pl.pfm.model.transaction.TransactionBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
//@ConditionalOnProperty(name = {"active.database"}, havingValue = "memory")
public class InMemoryDatabase implements Database {

  private final List<Transaction> transactions = new ArrayList<>();
  private final List<Category> categories = new ArrayList<>();
  private final List<Account> accounts = new ArrayList<>();

  private static AtomicInteger atomicTransactionID = new AtomicInteger(1);
  private static AtomicInteger atomicCategoryID = new AtomicInteger(1);
  private static AtomicInteger atomicAccountID = new AtomicInteger(1);

  //Transactions
  @Override
  public void saveTransaction(Transaction transaction) {
    transactions.add(transaction);
  }

  @Override
  public List<Transaction> getTransactions() {
    return transactions.stream().sorted().collect(Collectors.toList());
  }

  @Override
  public void removeTransaction(Transaction transaction) {
    Transaction foundTransaction = transactions
        .stream()
        .filter(transaction1 -> transaction1.getId().equals(transaction.getId()))
        .findFirst().get();
    transactions.remove(transactions.indexOf(foundTransaction));
  }

  @Override
  public Transaction createTransaction(TransactionBody transactionBody) {
    return TransactionBuilder.builder()
        .buildTransactionWithGeneratedId(transactionBody, getNextTransactionId());
  }

  @Override
  public Integer getNextTransactionId() {
    return atomicTransactionID.getAndIncrement();
  }

  //Categories

  @Override
  public void saveCategory(Category category) {
    categories.add(category);
  }

  @Override
  public List<Category> getCategories() {
    return categories.stream().sorted().collect(Collectors.toList());
  }

  @Override
  public void removeCategory(Category category) {
    Category foundCategory = categories
        .stream()
        .filter(category1 -> category1.getId().equals(category.getId()))
        .findFirst().get();
    transactions.remove(transactions.indexOf(foundCategory));
  }

  @Override
  public Category createCategory(CategoryBody categoryBody) {
    return CategoryBuilder.builder()
        .buildCategoryWithGeneratedId(categoryBody, getNextCategoryId());
  }

  @Override
  public Integer getNextCategoryId() {
    return atomicCategoryID.getAndIncrement();
  }

  //Account
  @Override
  public void saveAccount(Account account) {
    accounts.add(account);
  }

  @Override
  public void removeAccount(Account account) {
    Account foundAccount = accounts
        .stream()
        .filter(account1 -> account1.getId().equals(account.getId()))
        .findFirst().get();
    accounts.remove(accounts.indexOf(foundAccount));
  }

  @Override
  public List<Account> getAccounts() {
    return accounts;
  }

  @Override
  public Account createAccount(AccountBody accountBody) {
    return AccountBuilder.builder().buildAccountWithGeneratedId(accountBody, getNextAccountId());
  }

  @Override
  public Integer getNextAccountId() {
    return atomicAccountID.getAndIncrement();
  }


}