package mil.nga.efd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({
		"mil.nga.efd.services",
		"mil.nga.efd.controllers",
		"mil.nga.efd.scheduling"
})
@SpringBootApplication
public class EfdApplication {

	public static void main(String[] args) {
		SpringApplication.run(EfdApplication.class, args);
	}

}

