package g9.springframework.silkroad.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import g9.springframework.silkroad.models.Manager;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long> {
  Optional<Manager> findByEmail(String email);

}
