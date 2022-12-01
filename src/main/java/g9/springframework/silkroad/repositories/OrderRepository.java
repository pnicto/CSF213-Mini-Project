package g9.springframework.silkroad.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import g9.springframework.silkroad.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
  @Query(value = "SELECT SUM(total_price) FROM orders", nativeQuery = true)
  Double getTotalRevenue();

  @Query(value = "SELECT SUM(total_quantity) FROM orders WHERE created_at >= ?1", nativeQuery = true)
  Integer getTotalProductsSold(LocalDateTime localDateTime);

}
