package g9.springframework.silkroad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import g9.springframework.silkroad.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
