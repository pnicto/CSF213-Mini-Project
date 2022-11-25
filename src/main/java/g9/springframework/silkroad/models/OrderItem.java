package g9.springframework.silkroad.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderItem {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String name;
  @Column(columnDefinition = "TEXT")
  private Integer quantity;
  private String imageUrl;
  private Double price;
  private Long productId;

  public OrderItem(String name, String imageUrl, Double price, Integer quantity, Long productId) {
    this.name = name;
    this.quantity = quantity;
    this.imageUrl = imageUrl;
    this.price = price;
    this.productId = productId;
  }

}
