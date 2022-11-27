package g9.springframework.silkroad.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @OneToMany(cascade = CascadeType.ALL)
  private List<CartItem> cartItems;
  private double totalPrice;
  private Integer totalQuantity;

  public Cart() {
    this.cartItems = new ArrayList<>();
    this.totalPrice = 0;
    this.totalQuantity = 0;
  }

  public void addProductToCart(CartItem cartItem) {
    if (this.itemExists(cartItem)) {
      this.cartItems.forEach(item -> {
        if (item.getProduct().getId() == cartItem.getProduct().getId()) {
          item.setQuantity(item.getQuantity() + cartItem.getQuantity());
        }
      });
    } else {
      this.cartItems.add(cartItem);
    }
    this.totalPrice += cartItem.getProduct().getPrice() * cartItem.getQuantity();
    this.totalQuantity += cartItem.getQuantity();
  }

  public void addProductsToCart(List<CartItem> cartItems) {
    this.cartItems.addAll(cartItems);
    cartItems.forEach((cartItem) -> {
      this.totalPrice += cartItem.getProduct().getPrice();
      this.totalQuantity += cartItem.getQuantity();
    });
  }

  public void deleteItemFromCart(CartItem cartItem) {
    this.totalQuantity -= cartItem.getQuantity();
    this.totalPrice -= cartItem.getProduct().getPrice() * cartItem.getQuantity();
    this.cartItems.removeIf(item -> item.getId() == cartItem.getId());
  }

  public boolean itemExists(CartItem cartItem) {
    Iterator<CartItem> cIterator = this.cartItems.iterator();
    while (cIterator.hasNext()) {
      var item = cIterator.next();
      if (item.getProduct().getId() == cartItem.getProduct().getId()) {
        return true;
      }
    }
    return false;
  }
}
