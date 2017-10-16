package pl.pfm.repository;

import pl.pfm.database.Database;
import pl.pfm.database.impl.InMemoryDatabase;

public class PfmRepository {

  private final Database databese = new InMemoryDatabase();

  public Database getDatabese() {
    return databese;
  }
}
