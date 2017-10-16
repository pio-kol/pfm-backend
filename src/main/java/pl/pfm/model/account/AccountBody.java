package pl.pfm.model.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class AccountBody {

  private String accountName;
  private BigDecimal accountState;

  public AccountBody() {
  }

  @JsonCreator
  public AccountBody(@JsonProperty("accountName") String accountName,
      @JsonProperty("accountState") BigDecimal accountState) {

    this.accountName = accountName;
    this.accountState = accountState;
  }

  public String getAccountName() {
    return accountName;
  }

  public BigDecimal getAccountState() {
    return accountState;
  }

}
