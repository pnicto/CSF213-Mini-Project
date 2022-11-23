package g9.springframework.silkroad.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g9.springframework.silkroad.models.Cart;
import g9.springframework.silkroad.models.CartItem;
import g9.springframework.silkroad.models.Customer;
import g9.springframework.silkroad.models.Product;
import g9.springframework.silkroad.repositories.CustomerRepository;
import g9.springframework.silkroad.repositories.ProductRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customers/cart")
public class CartController {
  private final CustomerRepository customerRepository;
  private final ProductRepository productRepository;

  @GetMapping
  Cart getCustomerCart(Principal principal) {
    System.out.println(principal.getName());
    Optional<Customer> cOptional = customerRepository.findByEmail(principal.getName());
    if (cOptional.isPresent()) {
      System.out.println(cOptional.get());
      return cOptional.get().getCart();
    } else {
      throw new IllegalStateException("Customer does not exist");
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
}

record ProductToCartBody(
    Product product, Integer quantity) {

}