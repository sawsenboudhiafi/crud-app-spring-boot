package com.mn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.mn"})
public class CrudbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudbackApplication.class, args);
	}

}
