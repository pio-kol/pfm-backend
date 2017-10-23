package pl.pfm.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;
import pl.pfm.repository.TransactionRepository;

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

  public void addTransaction(TransactionBody transactionBody) {
    transactionRepository.save(transactionBody);
  }
}
