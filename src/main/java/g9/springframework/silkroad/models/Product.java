package g9.springframework.silkroad.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.google.gson.annotations.Expose;

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
  @Expose
  private String name;
  @Expose
  private String description;
  @Expose
  private double price;
  @Expose
  private String imageUrl;
  private int stock;
  private int deliveryTime;

  @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
  @JoinColumn(name = "category_id")
  private Category category;

  public Product(String name, String description, double price, String imageUrl, int deliveryTime) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.imageUrl = imageUrl;
    this.stock = 1;
    this.deliveryTime = deliveryTime;
  }

  public Product(String name, String description, double price, String imageUrl, int stock, int deliveryTime,
      Category category) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.imageUrl = imageUrl;
    this.stock = stock;
    this.deliveryTime = deliveryTime;
    this.category = category;
  }

}
