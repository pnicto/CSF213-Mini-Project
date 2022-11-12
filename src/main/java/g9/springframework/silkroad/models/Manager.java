package g9.springframework.silkroad.models;

import javax.persistence.Entity;

@Entity
public class Manager extends User {

  public Manager(String name, String email, String password, String phoneNumber) {
    super(name, email, password, Role.MANAGER, phoneNumber);
  }

}
