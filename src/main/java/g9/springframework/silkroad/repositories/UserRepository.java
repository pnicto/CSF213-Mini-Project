package g9.springframework.silkroad.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import g9.springframework.silkroad.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}
