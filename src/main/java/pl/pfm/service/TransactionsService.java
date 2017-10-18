package pl.pfm.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import pl.pfm.model.account.AccountBuilder;
import pl.pfm.model.category.CategoryBuilder;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;
import pl.pfm.model.transaction.TransactionBuilder;
import pl.pfm.model.transactions.Transactions;

@Service
public class TransactionsService {

  @Resource
  private final Transactions transactions;

  public TransactionsService(Transactions transactions) {
    this.transactions = transactions;
  }

  public Transaction getTransaction(Integer id) {
    return transactions.getTransactionById(id);
  }

  public int postTransaction(TransactionBody transactionBody) {
    Transaction transaction = createTransaction(transactionBody);
    transactions.addTransaction(transaction);
    return transaction.getId();
  }

  private Transaction createTransaction(TransactionBody transactionBody) {
    return TransactionBuilder
        .builder()
        .withId(transactions.getNextTransactionId())
        .withDate(transactionBody.getDate())
        .withDescription(transactionBody.getDescription())
        .withComment(transactionBody.getComment())
        .withCategory(CategoryBuilder.builder()
            .withCategoryId(transactionBody.getCategory().getId()))
        .withAccount(AccountBuilder.builder()
            .withAccountId(transactionBody.getAccount().getId())
            .withAccountName(transactionBody.getAccount().getName()))
        .withPrice(transactionBody.getPrice())
        .build();
  }

}
