package g9.springframework.silkroad.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g9.springframework.silkroad.models.Admin;
import g9.springframework.silkroad.repositories.AdminRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/admins")
@AllArgsConstructor
public class AdminController {
  private final AdminRepository adminRepository;

  @GetMapping
  Admin getCustomer(Principal principal) {
    Optional<Admin> aOptional = adminRepository.findByEmail(principal.getName());
    if (aOptional.isPresent()) {
      return aOptional.get();
    } else {
      throw new IllegalStateException("Admin not found");
    }
  }

}
