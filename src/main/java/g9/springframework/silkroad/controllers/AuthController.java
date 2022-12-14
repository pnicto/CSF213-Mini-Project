package g9.springframework.silkroad.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<Customer> register(@RequestBody RegistrationRequest request) {
    var newCustomer = authService.register(request.name(), request.email(),
        request.password(), request.phoneNumber(), request.address());
    return ResponseEntity.created(null).body(newCustomer);

  }

  @PostMapping("/login")
  public ResponseEntity<?> token(@RequestBody LoginRequest request) {
    var authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
    String token = tokenService.generateToken(authentication);
    Map<String, String> response = new HashMap<>();
    response.put("accessToken", token);
    response.put("scope", authentication.getAuthorities().toArray()[0].toString());
    return ResponseEntity.ok().body(response);
  }
}

record RegistrationRequest(
    String name,
    String email,
    String address,
    String password,
    String phoneNumber) {
}

record LoginRequest(String email, String password) {

}