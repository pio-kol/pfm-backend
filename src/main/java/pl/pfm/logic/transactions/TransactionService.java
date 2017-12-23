package pl.pfm.logic.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pfm.logic.accounts.AccountRepository;
import pl.pfm.logic.categories.CategoryRepository;
import pl.pfm.model.transaction.Transaction;
import pl.pfm.model.transaction.TransactionBody;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private CategoryRepository categoryRepository;
    private AccountRepository accountRepository;

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
                .category(categoryRepository.findOne(transactionBody.getCategory().getId()))
                .account(accountRepository.findOne(transactionBody.getAccount().getId()))
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
        Transaction transaction = transactionRepository.findOne(id);
        transaction.setDate(transactionBody.getDate());
        transaction.setDescription(transactionBody.getDescription());
        transaction.setComment(transactionBody.getComment());
        transaction.setCategory(categoryRepository.findOne(transactionBody.getCategory().getId()));
        transaction.setAccount(accountRepository.findOne(transactionBody.getAccount().getId()));
        transaction.setPrice(transactionBody.getPrice());

        transactionRepository.save(transaction);
        return transaction;
    }

    @Autowired
    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
