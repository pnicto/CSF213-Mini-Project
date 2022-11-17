package g9.springframework.silkroad.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Customer extends User {
  private int moneyInWallet;

  @OneToOne(cascade = CascadeType.ALL)
  private Cart cart;

  @OneToMany
  private List<Order> orders;

  public Customer(String name, String email, String password, String phoneNumber) {
    super(name, email, password, Role.CUSTOMER, phoneNumber);
    this.moneyInWallet = 1000;
  }

}
