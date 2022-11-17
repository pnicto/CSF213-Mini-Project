package g9.springframework.silkroad.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import g9.springframework.silkroad.models.Customer;
import g9.springframework.silkroad.repositories.CustomerRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
  private final CustomerRepository customerRepository;

  public Customer register(String name, String email, String password, String phoneNumber) {
    boolean isCustomerExists = customerRepository.findUserByEmail(email).isPresent();

    if (isCustomerExists) {
      throw new IllegalStateException("Customer already exists");
    } else {
      return customerRepository
          .save(new Customer(name, email, new BCryptPasswordEncoder().encode(password), phoneNumber));
    }
  }

  @Override
  public Customer login(String email, String password) {
    return null;
  }

}
