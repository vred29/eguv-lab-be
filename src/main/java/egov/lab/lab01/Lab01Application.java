package egov.lab.lab01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Lab01Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab01Application.class, args);
	}

}
