package sia11.finantel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinantelApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(FinantelApplication.class, args);
	}
}
