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
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {
  private final CustomerRepository customerRepository;

  @GetMapping
  Iterable<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  @PatchMapping
  Cart addToCart(@RequestBody ProductToCartBody requestBody, Principal principal) {
    Optional<Customer> cOptional = customerRepository.findByEmail(principal.getName());
    if (cOptional.isPresent()) {
      Cart cart = cOptional.get().getCart();
      cart.addProductToCart(new CartItem(requestBody.product(), requestBody.quantity()));
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