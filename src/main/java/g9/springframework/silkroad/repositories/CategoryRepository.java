package g9.springframework.silkroad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import g9.springframework.silkroad.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
