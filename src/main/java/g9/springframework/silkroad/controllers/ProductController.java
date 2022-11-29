package g9.springframework.silkroad.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import g9.springframework.silkroad.models.Category;
import g9.springframework.silkroad.models.Product;
import g9.springframework.silkroad.repositories.CategoryRepository;
import g9.springframework.silkroad.repositories.ProductRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ProductController {
  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;

  @GetMapping
  public Iterable<Product> getAllProducts(@RequestParam(value = "name") Long categoryId) {
    if (categoryId == 0) {
      return productRepository.findAll();
    } else {
      Optional<Category> categoryOpt = categoryRepository.findById((categoryId));
      if (categoryOpt.isPresent()) {
        return categoryOpt.get().getProducts();
      } else {
        throw new IllegalStateException("Category " + categoryId + " does not exist");
      }
    }
  }

  @GetMapping("/{id}")
  public Optional<Product> getProduct(@PathVariable("id") Long id) {
    return productRepository.findById(id);
  }

  @PostMapping
  public Product createNewProduct(@RequestBody Product newProduct) {
    return productRepository.save(newProduct);
  }

  @PatchMapping("/{id}")
  public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product updatedProduct) {
    Optional<Product> pOptional = productRepository.findById(id);
    if (pOptional.isPresent()) {
      return productRepository.save(updatedProduct);
    } else {
      throw new IllegalStateException("Product not found");
    }
  }

  @DeleteMapping("/{id}")
  public Iterable<Product> deleteProduct(@PathVariable("id") Long id) {
    productRepository.deleteById(id);
    return productRepository.findAll();
  }
}
