package g9.springframework.silkroad.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g9.springframework.silkroad.models.Cart;
import g9.springframework.silkroad.models.CartItem;
import g9.springframework.silkroad.models.Customer;
import g9.springframework.silkroad.models.Order;
import g9.springframework.silkroad.models.Product;
import g9.springframework.silkroad.repositories.CartItemRepository;
import g9.springframework.silkroad.repositories.CartRepository;
import g9.springframework.silkroad.repositories.CustomerRepository;
import g9.springframework.silkroad.repositories.ProductRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customers/cart")
public class CartController {
  private final CustomerRepository customerRepository;
  private final ProductRepository productRepository;
  private final CartRepository cartRepository;
  private final CartItemRepository cartItemRepository;

  @GetMapping
  Cart getCustomerCart(Principal principal) {
    Optional<Customer> cOptional = customerRepository.findByEmail(principal.getName());
    if (cOptional.isPresent()) {
      return cOptional.get().getCart();
    } else {
      throw new IllegalStateException("Customer does not exist");
    }
  }

  @PostMapping("/checkout")
  Order checkoutCart(Principal principal) {
    Optional<Customer> cOptional = customerRepository.findByEmail(principal.getName());
    if (cOptional.isPresent()) {
      Customer customer = cOptional.get();
      Cart cart = customer.getCart();
      Order order = new Order(cart.getCartItems(), cart.getTotalPrice());
      customer.setMoneyInWallet(customer.getMoneyInWallet() - cart.getTotalPrice());
      customer.getOrders().add(order);
      customer.setCart(new Cart());
      cartRepository.deleteById(cart.getId());
      customerRepository.save(customer);
      return order;
    } else {
      throw new IllegalStateException("Customer not found");
    }
  }

  @PatchMapping
  Cart addToCart(@RequestBody ProductToCartBody requestBody, Principal principal) {
    Optional<Customer> cOptional = customerRepository.findByEmail(principal.getName());
    Optional<Product> pOptional = productRepository.findById(requestBody.product().getId());

    if (cOptional.isPresent()) {
      Cart cart = cOptional.get().getCart();
      cart.addProductToCart(new CartItem(pOptional.get(), requestBody.quantity()));
      customerRepository.save(cOptional.get());
      return cart;
    } else {
      throw new IllegalStateException("Customer not found");
    }
  }

  @DeleteMapping("clear")
  Customer clearCart(Principal principal) {
    Optional<Customer> cOptional = customerRepository.findByEmail(principal.getName());
    if (cOptional.isPresent()) {
      Customer customer = cOptional.get();
      Cart customerCart = customer.getCart();
      customer.setCart(new Cart());
      cartRepository.deleteById(customerCart.getId());
      return customerRepository.save(customer);

    } else {
      throw new IllegalStateException("Customer not found");
    }
  }

  @DeleteMapping("{cartItemId}")
  Customer deleteProductFromCart(@PathVariable("cartItemId") String cartItemId, Principal principal) {
    Optional<Customer> cOptional = customerRepository.findByEmail(principal.getName());
    if (cOptional.isPresent()) {
      Customer customer = cOptional.get();
      Cart customerCart = customer.getCart();
      Optional<CartItem> cartItem = cartItemRepository.findById(Long.parseLong(cartItemId));
      customerCart.deleteItemFromCart(cartItem.get());
      cartItemRepository.delete(cartItem.get());
      customer.setCart(customerCart);
      return customerRepository.save(customer);

    } else {
      throw new IllegalStateException("Customer not found");
    }
  }
}

record ProductToCartBody(
    Product product, Integer quantity) {

}