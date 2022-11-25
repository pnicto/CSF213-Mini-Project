package g9.springframework.silkroad.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g9.springframework.silkroad.models.Customer;
import g9.springframework.silkroad.repositories.CustomerRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {
  private final CustomerRepository customerRepository;

  @GetMapping
  Customer getCustomer(Principal principal) {
    Optional<Customer> cOptional = customerRepository.findByEmail(principal.getName());
    if (cOptional.isPresent()) {
      return cOptional.get();
    } else {
      throw new IllegalStateException("Customer not found");
    }
  }

  @PatchMapping
  Customer updateCustomer(@RequestBody Customer updatedCustomer) {
    Optional<Customer> cOptional = customerRepository.findById(updatedCustomer.getId());
    if (cOptional.isPresent()) {
      cOptional.get().setName(updatedCustomer.getName());
      cOptional.get().setPhoneNumber(updatedCustomer.getPhoneNumber());
      cOptional.get().setMoneyInWallet(updatedCustomer.getMoneyInWallet());
      customerRepository.save(cOptional.get());
      return cOptional.get();
    } else {
      throw new IllegalStateException("Customer not found");
    }
  }
}
