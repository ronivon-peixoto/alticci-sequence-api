package com.apps.alticci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AlticciSequenceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlticciSequenceApiApplication.class, args);
	}

}
