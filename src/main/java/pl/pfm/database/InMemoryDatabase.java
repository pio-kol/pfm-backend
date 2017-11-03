package pl.pfm.database;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import pl.pfm.model.account.Account;
import pl.pfm.model.account.AccountBody;
import pl.pfm.model.account.AccountBuilder;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBody;
import pl.pfm.model.category.CategoryBuilder;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;
import pl.pfm.model.transaction.TransactionBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@ConditionalOnProperty(name = {"active.database"}, havingValue = "memory")
public class InMemoryDatabase implements Database {

  private final List<Transaction> transactions = new ArrayList<>();
  private AtomicInteger transactionId = new AtomicInteger(1);
  private final List<Account> accounts = new ArrayList<>();
  AtomicInteger accountId = new AtomicInteger(1);
  private final List<Category> categories = new ArrayList<>();
  AtomicInteger categoryId = new AtomicInteger(1);

  public InMemoryDatabase() {
    databaseInitializer();
  }

  private void databaseInitializer() {
    Transaction t1 = TransactionBuilder
        .builder()
        .withId(getNextTransactionId())
        .withDate(LocalDate.now())
        .withDescription("My new computer")
        .withComment("My first comment")
        .withCategory(CategoryBuilder.builder()
            .withCategoryId(1))
        .withAccount(AccountBuilder.builder()
            .withAccountId(1)
            .withAccountName("Idea"))
        .withPrice(BigDecimal.ONE)
        .build();

    Transaction t2 = TransactionBuilder
        .builder()
        .withId(getNextTransactionId())
        .withDate(LocalDate.now())
        .withDescription("My new computer 2")
        .withComment("My first comment 2")
        .withCategory(CategoryBuilder.builder()
            .withCategoryId(1))
        .withAccount(AccountBuilder.builder()
            .withAccountId(1)
            .withAccountName("Idea"))
        .withPrice(BigDecimal.ONE)
        .build();

    transactions.add(t1);
    transactions.add(t2);

    Category c1 = CategoryBuilder
        .builder()
        .withCategoryId(getNextCategoryId())
        .withCategoryName("Car")
        .withParentCategory(null)
        .build();

    Category c2 = CategoryBuilder
        .builder()
        .withCategoryId(getNextCategoryId())
        .withCategoryName("Car")
        .withParentCategory(null)
        .build();

    categories.add(c1);
    categories.add(c2);

    Account a1 = AccountBuilder
        .builder()
        .withAccountId(getNextAccountId())
        .withAccountName("mBank")
        .withAccountState(BigDecimal.valueOf(123.16))
        .build();

    Account a2 = AccountBuilder
        .builder()
        .withAccountId(getNextAccountId())
        .withAccountName("Inteligo")
        .withAccountState(BigDecimal.valueOf(234.56))
        .build();

    accounts.add(a1);
    accounts.add(a2);
  }

  @Override
  public long saveTransaction(TransactionBody transactionBody) {
    Transaction transaction = TransactionBuilder
        .builder()
        .buildTransactionWithId(getNextTransactionId(), transactionBody);
    transactions.add(transaction);
    return transaction.getId();
  }

  @Override
  public long saveTransaction(Transaction transaction) {
    transactions.add(transaction);
    return transaction.getId();
  }

  @Override
  public List<Transaction> findAllTransactions() {
    return transactions;
  }

  @Override
  public boolean deleteTransaction(long id) {
    Iterator<Transaction> transactionIterator = transactions.iterator();
    Transaction transaction = null;
    while (transactionIterator.hasNext()) {
      transaction = transactionIterator.next();
      if (transaction.getId() == id) {
        break;
      }
    }
    if (transaction != null) {
      transactions.remove(transaction);
      return true;
    }
    return false;
  }

  private int getNextTransactionId() {
    return transactionId.getAndIncrement();
  }

  @Override
  public long saveAccount(AccountBody accountBody) {
    Account account = AccountBuilder
        .builder()
        .buildAccountWithId(getNextAccountId(), accountBody);
    accounts.add(account);
    return account.getId();
  }

  @Override
  public long saveAccount(Account account) {
    accounts.add(account);
    return account.getId();
  }

  @Override
  public List<Account> findAllAccounts() {
    return accounts;
  }

  @Override
  public boolean deleteAccount(long id) {
    Iterator<Account> accountIterator = accounts.iterator();
    while (accountIterator.hasNext()) {
      if (accountIterator.next().getId() == id) {
        accountIterator.remove();
        return true;
      }
    }
    return false;
  }

  private int getNextAccountId() {
    return accountId.getAndIncrement();
  }

  @Override
  public long saveCategory(CategoryBody categoryBody) {
    Category category = CategoryBuilder
        .builder()
        .buildCategoryWithId(getNextCategoryId(), categoryBody);
    categories.add(category);
    return category.getId();
  }

  @Override
  public long saveCategory(Category category) {
    categories.add(category);
    return category.getId();
  }

  @Override
  public List<Category> findAllCategories() {
    return categories;
  }

  @Override
  public boolean deleteCategory(long id) {
    Iterator<Category> categoryIterator = categories.iterator();
    while (categoryIterator.hasNext()) {
      if (categoryIterator.next().getId() == id) {
        categoryIterator.remove();
        return true;
      }
    }
    return false;
  }

  private int getNextCategoryId() {
    return categoryId.getAndIncrement();
  }

}
