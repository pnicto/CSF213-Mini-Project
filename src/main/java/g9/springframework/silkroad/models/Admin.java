package g9.springframework.silkroad.models;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Admin extends User {

  public Admin(String name, String email, String password, String phoneNumber) {
    super(name, email, password, Role.ADMIN, phoneNumber);
  }

}
