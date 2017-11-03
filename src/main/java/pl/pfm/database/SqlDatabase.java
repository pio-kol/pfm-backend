package pl.pfm.database;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = {"active.database"}, havingValue = "sql")
public class SqlDatabase {

  @PersistenceContext
  private EntityManager entityManager;

}
