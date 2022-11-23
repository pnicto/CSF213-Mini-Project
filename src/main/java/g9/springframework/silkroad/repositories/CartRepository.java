package g9.springframework.silkroad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import g9.springframework.silkroad.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
