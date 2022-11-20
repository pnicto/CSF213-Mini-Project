package g9.springframework.silkroad.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String name;
  private String description;
  private double price;
  private String imageUrl;
  private int stock;
  private int deliveryTime;

  @ManyToOne
  private Category category;

  public Product(String name, String description, double price, String imageUrl, int stock, int deliveryTime) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.imageUrl = imageUrl;
    this.stock = stock;
    this.deliveryTime = deliveryTime;
  }

  public Product(String name, String description, double price, String imageUrl, int deliveryTime) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.imageUrl = imageUrl;
    this.stock = 1;
    this.deliveryTime = deliveryTime;
  }

}
