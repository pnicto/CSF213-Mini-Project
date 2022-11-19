package g9.springframework.silkroad;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import g9.springframework.silkroad.config.RsaKeyProperties;
import g9.springframework.silkroad.models.Admin;
import g9.springframework.silkroad.models.Manager;
import g9.springframework.silkroad.repositories.AdminRepository;
import g9.springframework.silkroad.repositories.ManagerRepository;
import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
@AllArgsConstructor
public class SilkroadApplication implements CommandLineRunner {
	private final AdminRepository adminRepository;
	private final ManagerRepository managerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SilkroadApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		adminRepository.save(new Admin("Abdul", "abdul@email.com", new BCryptPasswordEncoder().encode("password"), "101"));

		managerRepository
				.save(new Manager("James", "man@email.com", new BCryptPasswordEncoder().encode("bad@pple"), "420"));
	}

}
