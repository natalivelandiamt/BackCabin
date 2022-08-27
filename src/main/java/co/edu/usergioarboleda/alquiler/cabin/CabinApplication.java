package co.edu.usergioarboleda.alquiler.cabin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CabinApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabinApplication.class, args);
	}

}
