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

			List<Category> multiCat = new ArrayList<>();
			multiCat.add(new Category("1", "Frame", "frame", "http://res.cloudinary.com/kantilever/image/upload/v1484171995/frame_sdz97a.jpg"));
			multiCat.add(new Category("2", "Fiets","fiets", "http://res.cloudinary.com/kantilever/image/upload/v1484171994/bike1_ksjo64.jpg"));

			List<Category> fietsCat = new ArrayList<>();
			fietsCat.add(new Category("2", "Fiets", "fiets", "http://res.cloudinary.com/kantilever/image/upload/v1484171994/bike1_ksjo64.jpg"));

			List<Category> frameCat = new ArrayList<>();
			frameCat.add(new Category("1", "Frame", "frame", "http://res.cloudinary.com/kantilever/image/upload/v1484171995/frame_sdz97a.jpg"));

			List<Category> forkCat = new ArrayList<>();
			forkCat.add(new Category("3", "Fork", "fork", "http://res.cloudinary.com/kantilever/image/upload/v1484171994/fork3_svdu5x.jpg"));

			productRepository.save(new Product("1", 2L, "Road-150 Red, 62", "This bike is ridden by race winners. Developed with the Adventure Works Cycles professional race team, it has a extremely light heat-treated aluminum frame, and steering that allows precision control.", "http://res.cloudinary.com/kantilever/image/upload/v1484171992/bike3_vhdpgz.png", 1366, LocalDate.now(), LocalDate.now().plusDays(1), "LJ-0192-S", new Brand("2","Jumbo"), multiCat, "road-150-red-62"));
			productRepository.save(new Product("2", 8L, "HL Road Frame - Black, 58", "Our lightest and best quality aluminum frame made from the newest alloy; it is welded and heat-treated for strength. Our innovative design results in maximum comfort and performance.", "http://res.cloudinary.com/kantilever/image/upload/v1484171995/frame3_iz3yj5.jpg", 1364.50, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("1","Gazelle"), frameCat, "hl-road-frame-black-58"));
			productRepository.save(new Product("3", 2L, "Road-150 Frame Red, 62", "Our lightest and best quality aluminum frame made from the newest alloy; it is welded and heat-treated for strength. Our innovative design results in maximum comfort and performance.", "http://res.cloudinary.com/kantilever/image/upload/v1484171995/frame2_gpedbr.jpg", 1349.60, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("3", "Carbon"), frameCat, "road-150-frame-red-62"));
			productRepository.save(new Product("4", 9L, "Road-650 Red, 58", "Value-priced bike with many features of our top-of-the-line models. Has the same light, stiff frame, and the quick acceleration we're famous for.", "http://res.cloudinary.com/kantilever/image/upload/v1484171992/bike2_bodl90.png", 3578.27, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("3", "Carbon"), fietsCat, "road-650-red-58"));
			productRepository.save(new Product("5", 5L, "Mountain-100 Silver, 42", "Top-of-the-line competition mountain bike. Performance-enhancing options include the innovative HL Frame, super-smooth front suspension, and traction for all terrain.", "http://res.cloudinary.com/kantilever/image/upload/v1484171994/bike1_ksjo64.jpg", 1457.99, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("1", "Gazelle"), fietsCat, "mountain-100-silver-42"));

			productRepository.save(new Product("6", 5L, "LL Fork", "Stout design absorbs shock and offers more precise steering.", "http://res.cloudinary.com/kantilever/image/upload/v1484171994/fork3_svdu5x.jpg", 148.22, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("4", "ForksInc"), forkCat, "ll-fork"));
			productRepository.save(new Product("7", 9L, "ML Fork", "Composite road fork with an aluminum steerer tube.", "http://res.cloudinary.com/kantilever/image/upload/v1484171991/fork2_h5a2hp.jpg", 175.49, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("2", "Jumbo"), forkCat, "ml-fork"));
			productRepository.save(new Product("8", 5L, "HL Fork", "High-performance carbon road fork with curved legs.", "http://res.cloudinary.com/kantilever/image/upload/v1484171993/fork1_mmzbte.jpg", 192.47, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("4", "ForksInc"), forkCat, "hl-fork"));

			System.out.println("All products added");
			productRepository.findAll().forEach(System.out::println);
		};
	}
}
