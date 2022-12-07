package g9.springframework.silkroad.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
  private double moneyInWallet;

  @Column(columnDefinition = "TEXT")
  private String address;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "cart_id")
  private Cart cart;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Order> orders;

  public Customer(String name, String email, String password, String phoneNumber) {
    super(name, email, password, Role.CUSTOMER, phoneNumber);
    this.moneyInWallet = 1000;
    this.cart = new Cart();
    this.orders = new ArrayList<>();
    this.address = "56 Birchwood Dr.Voorhees, NJ 08043";
  }

  public Customer(String name, String email, String password, String phoneNumber, LocalDateTime createdAt) {
    super(name, email, password, Role.CUSTOMER, phoneNumber, createdAt);
    this.moneyInWallet = 1000;
    this.cart = new Cart();
    this.orders = new ArrayList<>();
    this.address = "56 Birchwood Dr.Voorhees, NJ 08043";
  }

  public Customer(String name, String email, String password, String phoneNumber, LocalDateTime createdAt,
      String address) {
    super(name, email, password, Role.CUSTOMER, phoneNumber, createdAt);
    this.moneyInWallet = 1000;
    this.cart = new Cart();
    this.orders = new ArrayList<>();
    this.address = address;
  }

  public Customer(String name, String email, String password, String phoneNumber,
      String address) {
    super(name, email, password, Role.CUSTOMER, phoneNumber, LocalDateTime.now());
    this.moneyInWallet = 1000;
    this.cart = new Cart();
    this.orders = new ArrayList<>();
    this.address = address;
  }

}
