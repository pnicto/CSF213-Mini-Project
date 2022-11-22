package g9.springframework.silkroad.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g9.springframework.silkroad.models.Product;
import g9.springframework.silkroad.repositories.ProductRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ProductController {
  private final ProductRepository productRepository;

  @GetMapping
  public Iterable<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Product> getProduct(@PathVariable("id") Long id) {
    System.out.println("Being called here");
    return productRepository.findById(id);
  }

  @PostMapping
  public Product createNewProduct(@RequestBody Product newProduct) {
    return productRepository.save(newProduct);
  }
}
