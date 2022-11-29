package g9.springframework.silkroad.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import g9.springframework.silkroad.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
  Optional<Customer> findByEmail(String email);

  void deleteByEmail(String email);
}
