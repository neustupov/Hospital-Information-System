package org.neustupov.pathologyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.neustupov")
public class PathologyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PathologyServiceApplication.class, args);
	}

}
