package pl.pfm.database.impl;


import org.springframework.stereotype.Service;
import pl.pfm.database.Database;
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
  private static AtomicInteger atomicInteger = new AtomicInteger(1);

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
        .filter(transaction1 -> transaction1. getId().equals(transaction.getId()))
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
    return atomicInteger.getAndIncrement();
  }

}