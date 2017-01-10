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

			productRepository.save(new Product("1", "awc_jersey_male_small.gif", 49.99, LocalDate.now(), LocalDate.now().plusDays(1), "LJ-0192-S", new Brand("brand1"), categories));
			productRepository.save(new Product("2", "frame_silver_small.gif", 1364.50, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("brand2"), categories));
			productRepository.save(new Product("3", "frame_black_small.gif", 1349.60, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("brand3"), categories));
			productRepository.save(new Product("4", "superlight_red_small.gif", 3578.27, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("brand3"), categories));
			productRepository.save(new Product("5", "roadster_red_small.gif", 1457.99, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("brand3"), categories));

			System.out.println("All products added");
			productRepository.findAll().forEach(System.out::println);
		};
	}
}
