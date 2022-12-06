package g9.springframework.silkroad.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  @OneToMany(cascade = CascadeType.ALL)
  private List<OrderItem> orderItems;
  private double totalPrice;
  private Integer totalQuantity;

  private LocalDateTime createdAt;

  public Order() {
    this.totalPrice = 0;
    this.orderItems = new ArrayList<>();
    this.createdAt = LocalDateTime.now();
  }

  public Order(List<CartItem> cartItems, double totalPrice) {
    this.totalPrice = totalPrice;
    this.orderItems = new ArrayList<>();
    this.createdAt = LocalDateTime.now();
    this.totalQuantity = 0;
    cartItems.forEach(cartItem -> {
      var product = cartItem.getProduct();
      this.totalQuantity += cartItem.getQuantity();
      this.orderItems.add(
          new OrderItem(product.getName(), product.getImageUrl(), product.getPrice(),
              cartItem.getQuantity(), product.getId()));
    });
  }

  public Order(List<CartItem> cartItems, double totalPrice, LocalDateTime localDateTime) {
    this.totalPrice = totalPrice;
    this.orderItems = new ArrayList<>();
    this.totalQuantity = 0;
    cartItems.forEach(cartItem -> {
      var product = cartItem.getProduct();
      this.totalQuantity += cartItem.getQuantity();
      this.orderItems.add(
          new OrderItem(product.getName(), product.getImageUrl(), product.getPrice(),
              cartItem.getQuantity(), product.getId()));
    });
    this.createdAt = localDateTime;
  }

}
