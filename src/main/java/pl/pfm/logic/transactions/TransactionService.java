package pl.pfm.transactions;

import org.springframework.stereotype.Service;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;
import pl.pfm.repository.TransactionRepository;

import javax.annotation.Resource;
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
        Transaction createdTransaction = Transaction.builder()
                .date(transactionBody.getDate())
                .description(transactionBody.getDescription())
                .comment(transactionBody.getComment())
                .category(transactionBody.getCategory())
                .account(transactionBody.getAccount())
                .price(transactionBody.getPrice())
                .build();

        transactionRepository.save(createdTransaction);
        return createdTransaction.getId();
    }

    public boolean deleteTransaction(long id) {
        transactionRepository.delete(id);
        return transactionRepository.findOne(id) == null;
    }

    public Transaction putTransaction(long id, TransactionBody transactionBody) {
        Iterator<Transaction> transactionIterator = transactionRepository.findAll().iterator();
        Transaction transaction = null;
        while (transactionIterator.hasNext()) {
            if (transactionIterator.next().getId() == id) {
                transaction =
                        Transaction.builder()
                                .date(transactionBody.getDate())
                                .description(transactionBody.getDescription())
                                .comment(transactionBody.getComment())
                                .category(transactionBody.getCategory())
                                .account(transactionBody.getAccount())
                                .price(transactionBody.getPrice())
                                .build();
                transactionRepository.save(transaction);
            }
        }
        return transaction;
    }


}
