package g9.springframework.silkroad.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer extends User {
  private int moneyInWallet;

  @OneToOne(cascade = CascadeType.ALL)
  private Cart cart;

  @OneToMany
  private List<Order> orders;

  public int getMoneyInWallet() {
    return moneyInWallet;
  }

  public void setMoneyInWallet(int moneyInWallet) {
    this.moneyInWallet = moneyInWallet;
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  public Customer(String name, String email, String password, String phoneNumber) {
    super(name, email, password, Role.CUSTOMER, phoneNumber);
    this.moneyInWallet = 1000;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

}
