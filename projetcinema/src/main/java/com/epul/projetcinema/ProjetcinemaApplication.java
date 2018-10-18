package com.epul.projetcinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.epul.projetcinema.dao")
public class ProjetcinemaApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjetcinemaApplication.class, args);
	}
}
