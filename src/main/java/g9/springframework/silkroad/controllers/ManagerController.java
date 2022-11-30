package g9.springframework.silkroad.controllers;

import java.security.Principal;
import java.util.Optional;

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

  @GetMapping
  Manager getCustomer(Principal principal) {
    Optional<Manager> mOptional = managerRepository.findByEmail(principal.getName());
    if (mOptional.isPresent()) {
      return mOptional.get();
    } else {
      throw new IllegalStateException("Manager not found");
    }
  }

  @GetMapping("/all")
  Iterable<Manager> getAllManagers() {
    return managerRepository.findAll();
  }

  @PostMapping
  Manager createNewManager(@RequestBody Manager newManager) {
    return managerRepository.save(newManager);
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
  void deleteManager(@PathVariable("managerId") String managerId) {
    managerRepository.deleteById(Long.parseLong(managerId));
  }
}
