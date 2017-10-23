package pl.pfm.model.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class AccountBody {

  private String name;
  private BigDecimal value;

  public AccountBody() {
  }

  @JsonCreator
  public AccountBody(@JsonProperty("name") String name,
      @JsonProperty("value") BigDecimal value) {

    this.name = name;
    this.value = value;
  }

  public String getAccountName() {
    return name;
  }

  public BigDecimal getAccountState() {
    return value;
  }

}
