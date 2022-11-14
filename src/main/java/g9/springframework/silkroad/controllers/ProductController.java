package g9.springframework.silkroad.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g9.springframework.silkroad.models.Product;
import g9.springframework.silkroad.repositories.ProductRepository;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
  private final ProductRepository productRepository;

  @Autowired
  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping
  public List<Product> getAllProducts() {
    List<Product> allProductList = new ArrayList<Product>();
    productRepository.findAll().iterator().forEachRemaining(allProductList::add);
    return allProductList;
  }

  @PostMapping
  public Product createNewProduct(@RequestBody Product newProduct) {
    return productRepository.save(newProduct);
  }
}
