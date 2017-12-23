package pl.pfm.logic.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pfm.model.account.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getAccountById(long id);
}
