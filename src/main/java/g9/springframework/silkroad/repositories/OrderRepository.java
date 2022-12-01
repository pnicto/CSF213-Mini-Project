package g9.springframework.silkroad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import g9.springframework.silkroad.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
