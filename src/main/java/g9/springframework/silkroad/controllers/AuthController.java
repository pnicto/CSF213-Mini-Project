package g9.springframework.silkroad.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import g9.springframework.silkroad.models.Customer;
import g9.springframework.silkroad.services.AuthService;
import g9.springframework.silkroad.services.TokenService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
public class AuthController {
  private final AuthService authService;
  private final TokenService tokenService;
  private final AuthenticationManager authenticationManager;

  @PostMapping("/register")
  public Customer register(@RequestBody RegistrationRequest request) {
    return authService.register(request.name(), request.email(), request.password(), request.phoneNumber());
  }

  @PostMapping("/login")
  public String token(@RequestBody LoginRequest request) {
    var authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
    System.out.println(authentication.getAuthorities());
    String token = tokenService.generateToken(authentication);
    return token;
  }
}

record RegistrationRequest(
    String name,
    String email,
    String password,
    String phoneNumber) {
}

record LoginRequest(String email, String password) {

}