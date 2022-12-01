package g9.springframework.silkroad.repositories;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import g9.springframework.silkroad.models.Customer;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  Optional<Customer> findByEmail(String email);

  Integer countByCreatedAtAfter(LocalDateTime date);

  void deleteByEmail(String email);
}
