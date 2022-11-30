package g9.springframework.silkroad.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import g9.springframework.silkroad.models.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
  Optional<Manager> findByEmail(String email);

}
