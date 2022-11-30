package g9.springframework.silkroad.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Customer extends User {
  private double moneyInWallet;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "cart_id")
  private Cart cart;

  @OneToMany(cascade = CascadeType.ALL)
  @OrderBy(value = "createdAt DESC")
  private List<Order> orders;

  public Customer(String name, String email, String password, String phoneNumber) {
    super(name, email, password, Role.CUSTOMER, phoneNumber);
    this.moneyInWallet = 1000;
    this.cart = new Cart();
    this.orders = new ArrayList<>();
  }

}
