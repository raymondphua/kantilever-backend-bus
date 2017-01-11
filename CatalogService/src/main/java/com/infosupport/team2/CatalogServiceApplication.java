package com.infosupport.team2;

import com.infosupport.team2.model.Brand;
import com.infosupport.team2.model.Category;
import com.infosupport.team2.model.Product;
import com.infosupport.team2.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
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
			categories.add(new Category("1", "Aandrijving en versnelling", "aandrijving-en-versnelling", "http://res.cloudinary.com/kantilever/image/upload/v1484137951/accu_elektrische_fiets_a5ic6v.jpg"));
			categories.add(new Category("2", "Accu elektrische fiets","accu-elektrische-fiets", "http://res.cloudinary.com/kantilever/image/upload/v1484137951/balhoofd_f6kbc6.jpg"));

			List<Category> categories2 = new ArrayList<>();
			categories2.add(new Category("3", "Bagagedragers", "bagagedragers", "http://res.cloudinary.com/kantilever/image/upload/v1484137951/bagagedragers_gwpwg6.jpg"));

			productRepository.save(new Product("1", 2L, "Long-Sleeve Logo Jersey, S", "Unisex long-sleeve AWC logo microfiber cycling jersey", "awc_jersey_male_small.gif", 49.99, LocalDate.now(), LocalDate.now().plusDays(1), "LJ-0192-S", new Brand("1","brand1"), categories2, "prod1"));
			productRepository.save(new Product("2", 8L, "HL Mountain Frame - Silver, 42", "Each frame is hand-crafted in our Bothell facility to the optimum diameter and wall-thickness required of a premium mountain frame. The heat-treated welded aluminum frame has a larger diameter tube that", "frame_silver_small.gif", 1364.50, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("2","brand2"), categories, "prod2"));
			productRepository.save(new Product("3", 2L, "Road-150 Red, 62", "This bike is ridden by race winners. Developed with the Adventure Works Cycles professional race team, it has a extremely light heat-treated aluminum frame, and steering that allows precision control.", "frame_black_small.gif", 1349.60, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("3", "brand3"), categories2, "prod3"));
			productRepository.save(new Product("4", 9L, "Road-650 Red, 58", "Value-priced bike with many features of our top-of-the-line models. Has the same light, stiff frame, and the quick acceleration we're famous for.", "superlight_red_small.gif", 3578.27, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("3", "brand3"), categories, "prod4"));
			productRepository.save(new Product("5", 5L, "Road-450 Red, 58", "A true multi-sport bike that offers streamlined riding and a revolutionary design. Aerodynamic design lets you ride with the pros, and the gearing will conquer hilly roads.", "roadster_red_small.gif", 1457.99, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("3", "brand3"), categories2, "prod5"));

			System.out.println("All products added");
			productRepository.findAll().forEach(System.out::println);
		};
	}
}
