package g9.springframework.silkroad.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g9.springframework.silkroad.models.Cart;
import g9.springframework.silkroad.models.Customer;
import g9.springframework.silkroad.repositories.CustomerRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customers/cart")
public class CartController {
  private final CustomerRepository customerRepository;

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

}
