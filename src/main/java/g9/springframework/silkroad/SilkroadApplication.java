package g9.springframework.silkroad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import g9.springframework.silkroad.config.RsaKeyProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class SilkroadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SilkroadApplication.class, args);
	}

}
