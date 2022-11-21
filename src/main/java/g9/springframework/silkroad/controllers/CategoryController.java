package g9.springframework.silkroad.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g9.springframework.silkroad.models.Category;
import g9.springframework.silkroad.repositories.CategoryRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/categories")
public class CategoryController {
  private final CategoryRepository categoryRepository;

  @GetMapping
  Iterable<Category> getAllCategories() {
    return categoryRepository.findAll();
  }
}
