package pl.pfm.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;
import pl.pfm.model.transaction.TransactionBuilder;
import pl.pfm.repository.TransactionRepository;

import java.util.Iterator;
import java.util.List;

@Service
public class TransactionService {

  @Resource
  private TransactionRepository transactionRepository;

  public TransactionService(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  public List<Transaction> getTransactions() {
    return transactionRepository.findAll();
  }

  public Transaction getOneTransaction(long id) {
    return transactionRepository.findOne(id);
  }

  public long postTransaction(TransactionBody transactionBody) {
    return transactionRepository.save(transactionBody);
  }

  public boolean deleteTransaction(long id) {
    return transactionRepository.delete(id);
  }

  public Transaction putTransaction(long id, TransactionBody transactionBody){
    Iterator<Transaction> transactionIterator = transactionRepository.findAll().iterator();
    Transaction transaction = null;
    while(transactionIterator.hasNext()){
      if((transaction = transactionIterator.next()).getId() == id){
       break;
      }
    }
    if(transaction != null){
      transactionRepository.delete(id);
      transaction = TransactionBuilder
          .builder()
          .buildTransactionWithId(id, transactionBody);
      transactionRepository.save(transaction);
    }
    return transaction;
  }

}
