package pl.pfm.database;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import pl.pfm.model.account.Account;
import pl.pfm.model.account.AccountBuilder;
import pl.pfm.model.category.Category;
import pl.pfm.model.category.CategoryBuilder;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@ConditionalOnProperty(name = {"active.database"}, havingValue = "memory")
public class InMemoryDatabase implements Database {

  private final List<Transaction> transactions = new ArrayList<>();
  private final List<Account> accounts = new ArrayList<>();
  private final List<Category> categories = new ArrayList<>();

  public InMemoryDatabase() {
    databaseInitializer();
  }

  private void databaseInitializer() {
    Transaction t1 = TransactionBuilder
        .builder()
        .withId(1)
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
        .withId(2)
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
        .withCategoryId(1)
        .withCategoryName("Car")
        .withParentCategory(null)
        .build();

    Category c2 = CategoryBuilder
        .builder()
        .withCategoryId(2)
        .withCategoryName("Car")
        .withParentCategory(null)
        .build();

    categories.add(c1);
    categories.add(c2);

    Account a1 = AccountBuilder
        .builder()
        .withAccountId(1)
        .withAccountName("mBank")
        .withAccountState(BigDecimal.valueOf(123.16))
        .build();

    Account a2 = AccountBuilder
        .builder()
        .withAccountId(1)
        .withAccountName("Inteligo")
        .withAccountState(BigDecimal.valueOf(234.56))
        .build();

    accounts.add(a1);
    accounts.add(a2);
  }


  public List<Transaction> getTransactions() {
    return transactions;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  public List<Category> getCategories() {
    return categories;
  }


}
