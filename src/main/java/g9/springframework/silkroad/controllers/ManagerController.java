package g9.springframework.silkroad.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g9.springframework.silkroad.models.Manager;
import g9.springframework.silkroad.repositories.ManagerRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/managers")
@AllArgsConstructor
public class ManagerController {
  private final ManagerRepository managerRepository;
  private final PasswordEncoder passwordEncoder;

  record RegistrationRequest(
      String name,
      String email,
      String password,
      String phoneNumber) {
  }

  @GetMapping
  Manager getManager(Principal principal) {
    Optional<Manager> mOptional = managerRepository.findByEmail(principal.getName());
    if (mOptional.isPresent()) {
      return mOptional.get();
    } else {
      throw new IllegalStateException("Manager not found");
    }
  }

  @GetMapping("/all")
  Iterable<Manager> getAllManagers() {
    return managerRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
  }

  @PostMapping
  Iterable<Manager> createNewManager(@RequestBody RegistrationRequest newManager) {
    managerRepository
        .save(new Manager(newManager.name(), newManager.email(), passwordEncoder.encode(newManager.password()),
            newManager.phoneNumber()));
    return managerRepository.findAll();
  }

  @PatchMapping
  Manager updateManager(@RequestBody Manager updatedManager, Principal principal) {
    Optional<Manager> cOptional = managerRepository.findByEmail(principal.getName());
    if (cOptional.isPresent()) {
      Manager manager = cOptional.get();
      manager.setName(updatedManager.getName());
      manager.setPhoneNumber(updatedManager.getPhoneNumber());
      managerRepository.save(manager);
      return manager;
    } else {
      throw new IllegalStateException("Manager not found");
    }
  }

  @DeleteMapping("/{managerId}")
  Iterable<Manager> deleteManager(@PathVariable("managerId") Long managerId) {
    managerRepository.deleteById(managerId);
    return managerRepository.findAll();
  }
}
