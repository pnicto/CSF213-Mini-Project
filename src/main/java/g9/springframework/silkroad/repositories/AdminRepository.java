package g9.springframework.silkroad.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import g9.springframework.silkroad.models.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long> {
  Optional<Admin> findByEmail(String email);

}
