package g9.springframework.silkroad.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g9.springframework.silkroad.models.User;
import g9.springframework.silkroad.repositories.UserRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @PatchMapping("/changePassword")
  User changeCustomerPassword(@RequestBody ChangePasswordBody requestBody, Principal principal) {
    Optional<User> optional = userRepository.findByEmail(principal.getName());
    boolean isCorrectPassword = passwordEncoder.matches(requestBody.oldPassword(), optional.get().getPassword());

    if (optional.isPresent() && isCorrectPassword) {
      User user = optional.get();
      user.setPassword(passwordEncoder.encode(requestBody.newPassword()));
      return userRepository.save(user);
    } else {
      throw new IllegalStateException("Customer not found");
    }
  }
}

record ChangePasswordBody(
    String oldPassword, String newPassword) {
}
