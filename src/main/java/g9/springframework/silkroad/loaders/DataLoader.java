package g9.springframework.silkroad.loaders;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import g9.springframework.silkroad.models.Admin;
import g9.springframework.silkroad.models.Category;
import g9.springframework.silkroad.models.Customer;
import g9.springframework.silkroad.models.Manager;
import g9.springframework.silkroad.models.Product;
import g9.springframework.silkroad.repositories.AdminRepository;
import g9.springframework.silkroad.repositories.CategoryRepository;
import g9.springframework.silkroad.repositories.CustomerRepository;
import g9.springframework.silkroad.repositories.ManagerRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {
  private final AdminRepository adminRepository;
  private final ManagerRepository managerRepository;
  private final CustomerRepository customerRepository;
  private final CategoryRepository categoryRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {

    // Load admin data
    adminRepository.save(new Admin("Abdul", "abdul@email.com", new BCryptPasswordEncoder().encode("password"), "101"));

    // Load manager data
    managerRepository
        .save(new Manager("James", "man@email.com", new BCryptPasswordEncoder().encode("badApple"), "420"));

    // Load customer data
    var john = customerRepository
        .save(new Customer("John", "john@email.com", new BCryptPasswordEncoder().encode("secret"), "666"));

    var steve = customerRepository
        .save(new Customer("Steve", "steve@email.com", new BCryptPasswordEncoder().encode("pwdpwd"), "666"));

    // Categories and products
    Category diary = new Category("Diary");
    Category pantry = new Category("Pantry");
    Category beverages = new Category("Beverages");

    var p1 = new Product("Goya Chorizos - 3.5oz",
        "Goya Chorizo, 3.5 Ounce | GOYA Chorizo is a delicious spanish dry hot sausage with a great texture and spiced with traditional seasonings. Perfect for everyday cooking in omelettes, as party snacks, or simply on it's own, Goya Chorizo is a delicious pantry staple that is sure to be a family favorite. Naturally smoked, and meaty and tasty on its own, Goya Chorizo also adds loads of flavor to rice dishes and stews—and of course, it makes fantastic tapas dishes! If it's Goya ... it has to be good!",
        3.29,
        "https://target.scene7.com/is/image/Target/GUEST_e5baf9e7-4476-402a-9c59-304dfa87c676", 2, pantry);

    var p2 = new Product("Country Crock Calcium Vegetable Oil Spread Tub - 15oz",
        "Bring authentic, country-fresh flavor to the table with Country Crock® Calcium Buttery Spread Tub - 15 oz. This buttery spread gives you the rich, creamy, and delicious flavor you love, along with 8% daily value of calcium per 1 tbsp serving. Slow-churned in Kansas and carefully crafted with farm-grown ingredients, you can always count on Country Crock to be free of any artificial flavors and preservatives. There's a reason Country Crock has been a trusted favorite at the center of family tables for generations!\n"
            +

            "Ready to use right out of the fridge, Country Crock Calcium Buttery Spread can be spread on top of your favorite breads and pastries for a deliciously decadent buttery treat. Use it as a secret ingredient to add depth of flavor and richness to your cooking and baking favorites from appetizers to main dishes, desserts, and more. Country Crock Calcium is free of gluten, hydrogenated oils, dairy, and lactose, has 0g cholesterol and trans fat per 1 tbsp serving, and has 75% less saturated fat than a 1 tbsp serving of traditional dairy butter.\n"
            +
            "Brought to you by Country Crock, a brand committed to welcoming everyone to the table. We treat everyone like family and every place like home. Our products are sustainably farmed and responsibly sourced. When you can spread, top, cook and bake just about anything with this buttery spread, the options are endless with Country Crock!",
        10.99,
        "https://target.scene7.com/is/image/Target/GUEST_200ad2d7-68e1-4562-bece-bc219e359e89", 2, diary);

    var p3 = new Product("Lion Coffee Lion Gold Medium Roast Ground Coffee - 10oz",
        "LION Gold Coffee is a classic medium-light roast coffee that makes a great breakfast coffee. This means that there is some real caffeine kick in this bag to get your day started! This LION Coffee brew is bright in the cup with a mellow taste and sweet, delicate, and slightly citrus finish.",
        7.39, "https://target.scene7.com/is/image/Target/GUEST_41282053-add3-4bc7-a40c-46670c171932", 3, beverages);

    pantry.setProducts(List.of(p1));
    diary.setProducts(List.of(p2));
    beverages.setProducts(List.of(p3));

    categoryRepository.save(diary);
    categoryRepository.save(pantry);
    categoryRepository.save(beverages);

    john.getCart().addProductToCart(p2);
    john.getCart().addProductToCart(p3);

    steve.getCart().addProductToCart(p1);
    steve.getCart().addProductToCart(p2);

    customerRepository.save(john);
    customerRepository.save(steve);
  }

}
