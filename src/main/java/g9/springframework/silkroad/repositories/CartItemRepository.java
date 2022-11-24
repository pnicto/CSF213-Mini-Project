package g9.springframework.silkroad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import g9.springframework.silkroad.models.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
