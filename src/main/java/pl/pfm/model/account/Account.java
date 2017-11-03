package pl.pfm.model.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private BigDecimal value;

  public Account() {
  }

  public Account(long accountId, String accountName, BigDecimal value) {
    this.id = accountId;
    this.name = accountName;
    this.value = value;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getValue() {
    return value;
  }
}
