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

import org.hibernate.annotations.CreationTimestamp;

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

  @CreationTimestamp
  private LocalDateTime createdAt;

  public Order() {
    this.totalPrice = 0;
    this.orderItems = new ArrayList<>();
  }

  public Order(List<CartItem> cartItems, double totalPrice) {
    this.totalPrice = totalPrice;
    this.orderItems = new ArrayList<>();
    cartItems.forEach(cartItem -> {
      var product = cartItem.getProduct();
      this.orderItems.add(
          new OrderItem(product.getName(), product.getDescription(), product.getImageUrl(), product.getPrice(),
              cartItem.getQuantity()));
    });
  }

}
