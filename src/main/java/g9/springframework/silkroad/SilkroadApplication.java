package g9.springframework.silkroad;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import g9.springframework.silkroad.config.RsaKeyProperties;
import g9.springframework.silkroad.models.Admin;
import g9.springframework.silkroad.models.Manager;
import g9.springframework.silkroad.models.Product;
import g9.springframework.silkroad.repositories.AdminRepository;
import g9.springframework.silkroad.repositories.ManagerRepository;
import g9.springframework.silkroad.repositories.ProductRepository;
import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
@AllArgsConstructor
public class SilkroadApplication implements CommandLineRunner {
	private final AdminRepository adminRepository;
	private final ManagerRepository managerRepository;
	private final ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SilkroadApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		adminRepository.save(new Admin("Abdul", "abdul@email.com", new BCryptPasswordEncoder().encode("password"), "101"));

		managerRepository
				.save(new Manager("James", "man@email.com", new BCryptPasswordEncoder().encode("bad@pple"), "420"));

		productRepository.save(new Product("Tesco Fun Animal Beach Towel", "A fucking towel", 15.7,
				"https://digitalcontent.api.tesco.com/v2/media/ghs/b8c89397-539c-46f5-9e24-a27e92536a71/02f8883c-a4d9-45a3-84a8-04fc193539e9_1519487458.jpeg",
				3));
		productRepository.save(new Product("Tesco Fun Animal Beach Towel", "A fucking towel", 15.7,
				"https://digitalcontent.api.tesco.com/v2/media/ghs/b8c89397-539c-46f5-9e24-a27e92536a71/02f8883c-a4d9-45a3-84a8-04fc193539e9_1519487458.jpeg",
				3));
		productRepository.save(new Product("Tesco Fun Animal Beach Towel", "A fucking towel", 15.7,
				"https://digitalcontent.api.tesco.com/v2/media/ghs/b8c89397-539c-46f5-9e24-a27e92536a71/02f8883c-a4d9-45a3-84a8-04fc193539e9_1519487458.jpeg",
				3));
		productRepository.save(new Product("Tesco Fun Animal Beach Towel", "A fucking towel", 15.7,
				"https://digitalcontent.api.tesco.com/v2/media/ghs/b8c89397-539c-46f5-9e24-a27e92536a71/02f8883c-a4d9-45a3-84a8-04fc193539e9_1519487458.jpeg",
				3));
		productRepository.save(new Product("Tesco Fun Animal Beach Towel", "A fucking towel", 15.7,
				"https://digitalcontent.api.tesco.com/v2/media/ghs/b8c89397-539c-46f5-9e24-a27e92536a71/02f8883c-a4d9-45a3-84a8-04fc193539e9_1519487458.jpeg",
				3));
		productRepository.save(new Product("Tesco Fun Animal Beach Towel", "A fucking towel", 15.7,
				"https://digitalcontent.api.tesco.com/v2/media/ghs/b8c89397-539c-46f5-9e24-a27e92536a71/02f8883c-a4d9-45a3-84a8-04fc193539e9_1519487458.jpeg",
				3));
	}

}
