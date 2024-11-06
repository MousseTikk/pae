package g56583.web5.pae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.transaction.Transactional;

@Transactional
@SpringBootApplication
public class PaeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaeApplication.class, args);
	}

}
