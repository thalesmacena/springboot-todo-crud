package br.com.example.todocrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class TodoCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoCrudApplication.class, args);
	}

}
