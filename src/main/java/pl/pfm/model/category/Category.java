package pl.pfm.model.category;

import javax.persistence.*;

import lombok.*;

import java.util.Collection;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  @ManyToOne
  private Category parentCategory;

}
