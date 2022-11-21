package g9.springframework.silkroad.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
  @Column(columnDefinition = "TEXT")
  private String description;
  @Expose
  private double price;
  @Expose
  private String imageUrl;
  private Boolean isAvailable;
  private int deliveryTime;

  @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
  @JoinColumn(name = "category_id")
  @JsonBackReference
  private Category category;

  public Product(String name, String description, double price, String imageUrl, int deliveryTime, Category category) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.imageUrl = imageUrl;
    this.isAvailable = true;
    this.deliveryTime = deliveryTime;
    this.category = category;
  }

  public Product(String name, String description, double price, String imageUrl, Boolean isAvailable, int deliveryTime,
      Category category) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.imageUrl = imageUrl;
    this.isAvailable = isAvailable;
    this.deliveryTime = deliveryTime;
    this.category = category;
  }

}
