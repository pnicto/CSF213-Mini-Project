package g9.springframework.silkroad.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
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
  private final PasswordEncoder passwordEncoder;

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
      Customer customer = cOptional.get();
      customer.setName(updatedCustomer.getName());
      customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
      customer.setMoneyInWallet(updatedCustomer.getMoneyInWallet());
      customerRepository.save(customer);
      return customer;
    } else {
      throw new IllegalStateException("Customer not found");
    }
  }

  @PatchMapping("/changePassword")
  Customer changeCustomerPassword(@RequestBody ChangePasswordBody requestBody, Principal principal) {
    Optional<Customer> cOptional = customerRepository.findByEmail(principal.getName());
    boolean isCorrectPassword = passwordEncoder.matches(requestBody.oldPassword(), cOptional.get().getPassword());

    if (cOptional.isPresent() && isCorrectPassword) {
      Customer customer = cOptional.get();
      customer.setPassword(passwordEncoder.encode(requestBody.newPassword()));
      return customerRepository.save(customer);
    } else {
      throw new IllegalStateException("Customer not found");
    }
  }
}

record ChangePasswordBody(
    String oldPassword, String newPassword) {
}