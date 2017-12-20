package pl.pfm.model.account;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Account {
  private long id;
  private String name;
  private BigDecimal value;
}
