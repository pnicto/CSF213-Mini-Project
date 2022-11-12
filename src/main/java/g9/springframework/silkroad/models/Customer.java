package g9.springframework.silkroad.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Customer extends User {
  private int moneyInWallet;

  @OneToOne(cascade = CascadeType.ALL)
  private Cart cart;

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
}
