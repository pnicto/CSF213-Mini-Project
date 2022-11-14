package g9.springframework.silkroad.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g9.springframework.silkroad.models.Manager;
import g9.springframework.silkroad.repositories.ManagerRepository;

@RestController
@RequestMapping("api/v1/managers")
public class ManagerController {
  private final ManagerRepository managerRepository;

  @Autowired
  public ManagerController(ManagerRepository managerRepository) {
    this.managerRepository = managerRepository;
  }

  @GetMapping
  List<Manager> getAllManagers() {
    List<Manager> allManagerList = new ArrayList<Manager>();
    managerRepository.findAll().iterator().forEachRemaining(allManagerList::add);
    return allManagerList;
  }

  @PostMapping
  Manager createNewManager(@RequestBody Manager newManager) {
    return managerRepository.save(newManager);
  }

  @DeleteMapping("/{managerId}")
  void deleteManager(@PathVariable("managerId") String managerId) {
    managerRepository.deleteById(Long.parseLong(managerId));
  }
}
