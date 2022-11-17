package g9.springframework.silkroad.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g9.springframework.silkroad.models.Customer;
import g9.springframework.silkroad.services.AuthService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping("/register")
  public Customer register(@RequestBody RegistrationRequest request) {
    return authService.register(request.getName(), request.getEmail(), request.getPassword(), request.getPhoneNumber());
  }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class RegistrationRequest {
  private String name;
  private String email;
  private String password;
  private String phoneNumber;
}