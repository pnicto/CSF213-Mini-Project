package g9.springframework.silkroad.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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

  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
  @JoinTable(name = "cart_products", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))

  private List<Product> products;
  private double totalPrice;

  public Cart(List<Product> products) {
    this.products = products;
    this.totalPrice = 0;
  }

  public Cart() {
    this.products = new ArrayList<>();
    this.totalPrice = 0;
  }

  public void addProductToCart(Product product) {
    this.products.add(product);
    this.totalPrice += product.getPrice();
  }

  public void addProductsToCart(List<Product> products) {
    this.products.addAll(products);
    products.forEach((product) -> {
      this.totalPrice += product.getPrice();
    });
  }
}
