package g9.springframework.silkroad.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import g9.springframework.silkroad.models.Customer;
import g9.springframework.silkroad.repositories.CustomerRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
  private final CustomerRepository customerRepository;
  private final PasswordEncoder passwordEncoder;

  public Customer register(String name, String email, String password, String phoneNumber, String address) {
    boolean isCustomerExists = customerRepository.findByEmail(email).isPresent();

    if (isCustomerExists) {
      throw new IllegalStateException("Customer already exists");
    } else {
      return customerRepository
          .save(new Customer(name, email, passwordEncoder.encode(password), phoneNumber, address));
    }
  }

  @Override
  public Customer login(String email, String password) {
    return null;
  }

}
