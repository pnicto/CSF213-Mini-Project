package g9.springframework.silkroad.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
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
  Customer updateCustomer(@RequestBody Customer updatedCustomer, Principal principal) {
    Optional<Customer> cOptional = customerRepository.findByEmail(principal.getName());
    if (cOptional.isPresent()) {
      Customer customer = cOptional.get();
      customer.setName(updatedCustomer.getName());
      customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
      customerRepository.save(customer);
      return customer;
    } else {
      throw new IllegalStateException("Customer not found");
    }
  }

  @PatchMapping("/topup")
  Customer updateWallet(@RequestBody WalletBody requestBody, Principal principal) {
    Optional<Customer> cOptional = customerRepository.findByEmail(principal.getName());
    if (cOptional.isPresent()) {
      Customer customer = cOptional.get();
      customer.setMoneyInWallet(customer.getMoneyInWallet() + requestBody.amount());
      return customerRepository.save(customer);
    } else {
      throw new IllegalStateException("Customer not found");
    }
  }

  @DeleteMapping
  void deleteCustomer(Principal principal) {
    customerRepository.deleteByEmail(principal.getName());
  }
}

record WalletBody(
    Double amount) {
}