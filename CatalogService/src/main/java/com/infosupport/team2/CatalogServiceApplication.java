package com.infosupport.team2;

import com.infosupport.team2.model.Brand;
import com.infosupport.team2.model.Category;
import com.infosupport.team2.model.Product;
import com.infosupport.team2.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}

	//test repository
	@Bean
	CommandLineRunner onStartup(ProductRepository productRepository) {
		return (String... args) -> {
			productRepository.deleteAll();

			List<Category> categories = new ArrayList<>();
			categories.add(new Category("category-x"));
			categories.add(new Category("category-y"));

			productRepository.save(new Product("1", "testUrl", 20.3, LocalDate.now(), LocalDate.now().plusDays(1), "supplierId123", new Brand("brand1"), categories));
			productRepository.save(new Product("2", "testUrl2", 33.3, LocalDate.now(), LocalDate.now().plusDays(1), "supplierId321", new Brand("brand2"), categories));

			System.out.println("All products added");
			productRepository.findAll().forEach(System.out::println);
		};
	}
}
