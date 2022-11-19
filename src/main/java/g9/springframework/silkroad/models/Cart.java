package g9.springframework.silkroad.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToMany
  private List<Product> products;
  private int totalPrice;
  private int totalQuantity;

  public Cart(List<Product> products) {
    this.products = products;
    this.totalPrice = 0;
    this.totalQuantity = 0;
  }

  public Cart() {
    this.products = new ArrayList<>();
    this.totalPrice = 0;
    this.totalQuantity = 0;
  }
}
