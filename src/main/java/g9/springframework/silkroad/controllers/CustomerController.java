package g9.springframework.silkroad.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g9.springframework.silkroad.models.Customer;
import g9.springframework.silkroad.repositories.CustomerRepository;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
  private final CustomerRepository customerRepository;

  @Autowired
  public CustomerController(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @GetMapping
  List<Customer> getAllCustomers() {
    List<Customer> allCustomerList = new ArrayList<Customer>();
    customerRepository.findAll().iterator().forEachRemaining(allCustomerList::add);
    return allCustomerList;
  }

  @PostMapping
  Customer createNewCustomer(@RequestBody Customer newCustomer) {
    return customerRepository.save(newCustomer);
  }

  @DeleteMapping("/{customerId}")
  void updateCustomer(@PathVariable("customerId") String customerId) {
    customerRepository.deleteById(Long.parseLong(customerId));
  }
}
