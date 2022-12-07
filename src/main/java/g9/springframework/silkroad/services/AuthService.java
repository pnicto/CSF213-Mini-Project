package g9.springframework.silkroad.services;

import g9.springframework.silkroad.models.Customer;

public interface AuthService {
  Customer register(String name, String email, String password, String phoneNumber, String address);

  Customer login(String email, String password);
}
