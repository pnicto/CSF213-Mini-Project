package g9.springframework.silkroad.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String name;

  @OneToMany(mappedBy = "category", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
      CascadeType.DETACH })
  @JsonBackReference
  @OrderBy(value = "name ASC")
  private List<Product> products;

  public Category(String name) {
    this.name = name;
    this.products = new ArrayList<>();
  }

}
