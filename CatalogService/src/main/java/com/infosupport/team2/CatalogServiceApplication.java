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
			forkCat.add(new Category("3", "Voorvorken", "voorvorken", "http://res.cloudinary.com/kantilever/image/upload/v1484171994/fork3_svdu5x.jpg"));

			List<Category> paintCat = new ArrayList<>();
			paintCat.add(new Category("4", "Lak", "lak", ""));

			List<Category> zadelCat = new ArrayList<>();
			zadelCat.add(new Category("5", "Zadels", "zadels", ""));

			List<Category> fietsVerlichtingCat = new ArrayList<>();
			fietsVerlichtingCat.add(new Category("6", "Fietsverlichting", "fietsverlichting", ""));

			List<Category> pedalenCat = new ArrayList<>();
			pedalenCat.add(new Category("7", "Pedalen", "pedalen", ""));

			productRepository.save(new Product("1", 2L,"BAT", "Road-150 Red, 62", "This bike is ridden by race winners. Developed with the Adventure Works Cycles professional race team, it has a extremely light heat-treated aluminum frame, and steering that allows precision control.", "http://res.cloudinary.com/kantilever/image/upload/v1484171992/bike3_vhdpgz.png", 1366, LocalDate.now(), LocalDate.now().plusDays(1), "LJ-0192-S", new Brand("2","Jumbo"), multiCat, "road-150-red-62"));
			productRepository.save(new Product("2", 8L, "KOG", "HL Road Frame - Black, 58", "Our lightest and best quality aluminum frame made from the newest alloy; it is welded and heat-treated for strength. Our innovative design results in maximum comfort and performance.", "http://res.cloudinary.com/kantilever/image/upload/v1484171995/frame3_iz3yj5.jpg", 1364.50, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("1","Gazelle"), frameCat, "hl-road-frame-black-58"));
			productRepository.save(new Product("3", 2L, "BAT", "Road-150 Frame Red, 62", "Our lightest and best quality aluminum frame made from the newest alloy; it is welded and heat-treated for strength. Our innovative design results in maximum comfort and performance.", "http://res.cloudinary.com/kantilever/image/upload/v1484171995/frame2_gpedbr.jpg", 1349.60, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("3", "Carbon"), frameCat, "road-150-frame-red-62"));
			productRepository.save(new Product("4", 9L, "EDD", "Road-650 Red, 58", "Value-priced bike with many features of our top-of-the-line models. Has the same light, stiff frame, and the quick acceleration we're famous for.", "http://res.cloudinary.com/kantilever/image/upload/v1484171992/bike2_bodl90.png", 3578.27, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("3", "Carbon"), fietsCat, "road-650-red-58"));
			productRepository.save(new Product("5", 5L, "UNI", "Mountain-100 Silver, 42", "Top-of-the-line competition mountain bike. Performance-enhancing options include the innovative HL Frame, super-smooth front suspension, and traction for all terrain.", "http://res.cloudinary.com/kantilever/image/upload/v1484171994/bike1_ksjo64.jpg", 1457.99, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("1", "Gazelle"), fietsCat, "mountain-100-silver-42"));

			productRepository.save(new Product("6", 5L, "UNI", "LL Fork", "Stout design absorbs shock and offers more precise steering.", "http://res.cloudinary.com/kantilever/image/upload/v1484171994/fork3_svdu5x.jpg", 148.22, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("4", "ForksInc"), forkCat, "ll-fork"));
			productRepository.save(new Product("7", 9L, "EDD", "ML Fork", "Composite road fork with an aluminum steerer tube.", "http://res.cloudinary.com/kantilever/image/upload/v1484171991/fork2_h5a2hp.jpg", 175.49, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("2", "Jumbo"), forkCat, "ml-fork"));
			productRepository.save(new Product("8", 5L, "UNI", "HL Fork", "High-performance carbon road fork with curved legs.", "http://res.cloudinary.com/kantilever/image/upload/v1484171993/fork1_mmzbte.jpg", 192.47, LocalDate.now(), LocalDate.now().plusDays(1), "FR-M94S-42", new Brand("4", "ForksInc"), forkCat, "hl-fork"));

			productRepository.save(new Product("9", 10L, "CYC","Cyclus lakstift mat wit", "Cyclus lakstift mat wit", "http://res.cloudinary.com/kantilever/image/upload/v1485266797/LKSC005.jpg_whvceb.jpg", 5.50, LocalDate.now(), LocalDate.now().plusDays(1),"LKSC005", new Brand("5", "Cyclus"), paintCat, "cyclus-lakstift-mat-wit"));
			productRepository.save(new Product("10", 10L, "CYC","Cyclus spuitlak 400cc hittebest zilver", "Cyclus spuitlak 400cc hittebest zilver", "http://res.cloudinary.com/kantilever/image/upload/v1485267229/SLKC4004.jpg_c5kwig.jpg", 13.50, LocalDate.now(), LocalDate.now().plusDays(1),"SLKC4004", new Brand("5", "Cyclus"), paintCat, "cyclus-spuitlak-400cc-hittebest-zilver"));

			productRepository.save(new Product("11", 11L, "SEL", "Selle Royal zadel 5132 unisex Respiro soft Relaxed zwart", "Selle Royal zadel 5132 unisex Respiro soft Relaxed zwart.\n" + "\n" + "Cool Xsenium, Respiro Soft Relaxed is een ideaal zadel wanneer comfort bij fietsen in een rechte zitpositie prioriteit heeft. De Royalgel zadelvulling vermindert de druk op drukpunten tot 40 procent. Het speciale ventilatiekanaal verbetert de luchtcirculatie bij het zitvlak van de fietser, zodat de temperatuur van het zadel laag blijft, bij warm weer en lange afstanden.", "http://res.cloudinary.com/kantilever/image/upload/v1485267923/zdsr5132d17.1_pg3no9.jpg", 48.95, LocalDate.now(), LocalDate.now().plusDays(1),"ZDSR5132D17", new Brand("6", "Selle Royal"), zadelCat, "selle-royal-zadel-5132-unisex-respiro-soft-relaxed-zwart"));
			productRepository.save(new Product("12", 12L, "BRO","Brooks unisex zadel C13 Cambium Carved zwart", "Brooks zadel Cambium C13 Carved zwart.\n" + "\n" + "Breedte 132mm, Carbon enkele brug, dek waterafstotend en onderhoudsvrij,", "http://res.cloudinary.com/kantilever/image/upload/v1485268225/zdbc213cvz.1_suxwt2.jpg", 154.95, LocalDate.now(), LocalDate.now().plusDays(1),"ZDBC213CVZ", new Brand("7", "Brooks"), zadelCat, "brooks-unisex-zadel-c13-cambium-carved-zwart"));
			productRepository.save(new Product("13", 11L, "SEL","Selle Bassano kinderzadel Fiorella 12/16 inch wit roze", "Selle Bassano kinderzadel Fiorella 12/16 inch wit roze", "http://res.cloudinary.com/kantilever/image/upload/v1485268397/ZDSB415.jpg_azhg3c.jpg", 13.70, LocalDate.now(), LocalDate.now().plusDays(1),"ZDSB415", new Brand("6", "Selle Royal"), zadelCat, "selle-bassano-kinderzadel-fiorella-12-16-inch-wit-roze"));

			productRepository.save(new Product("14", 12L, "UNI","Union achterlicht op spatbord led", "Union achterlicht op spatbord led\n" + "\n" + "UN-4370 AM\n" + "\n" + "LED spatbord achterlicht\n" + "\n" + "(naaf) dynamo uitvoering\n" + "\n" + "modern\n" + "\n" + "voorzien van een lichttunnel met 1 LED, RVS bevestigings-materiaal\n" + "\n" + "Duitse goedkeur\n" + "\n" + "met externe kabelaansluitingen en standlichtfunctie", "http://res.cloudinary.com/kantilever/image/upload/v1485268729/un4370_rmoyqn.jpg", 5.95, LocalDate.now(), LocalDate.now().plusDays(1),"UN4370", new Brand("8", "Union"), fietsVerlichtingCat, "union-achterlicht-op-spatbord-led"));
			productRepository.save(new Product("15", 13L, "AXA", "AXA Voorlicht Scope LED 4 LUX vorkbevestiging", "De AXA Scope is een standaard LED batterijkoplamp met een lichtopbrengst tot 4 lux en 2 heldere LED’s, uitermate geschikt voor kinder- en stadsfietsen. \n" + "De geïntegreerde retroreflector zorgt ervoor dat u beter zichtbaar bent voor tegemoetkomend verkeer.\n" + "De stevige aan/uit-schakelaar is eenvoudig te bedienen. De Scope is voorzien van een glasfiber beugel, een zeer stevig materiaal dat niet makkelijk breekt.\n" + "De Scope is leverbaar met een beugel voor montage op de vork. \n" + "\n" + "Lichtbundel: 15 meter ‘zien’, 1000 meter ‘gezien worden’.", "http://res.cloudinary.com/kantilever/image/upload/v1485270146/131858_vhej9f.jpg", 17.85, LocalDate.now(), LocalDate.now().plusDays(1),"131858", new Brand("11", "AXA"), fietsVerlichtingCat, "voorlicht-led-axa-batterij-scope-4-lux-vorkbevestiging"));

			productRepository.save(new Product("16", 14L, "SIM", "Simson pedalen Sport Deluxe", "Stevige en luxe aluminium pedalen vervaardigd uit een stuk voor de Trekking of ATB fiets. Tevens zeer geschikt voor de E-bike en tourfiets. Uitgevoerd in luxe duo color zwart/zilver en voorzien van reflectoren.", "http://res.cloudinary.com/kantilever/image/upload/v1485269568/de_luxe_dzpclh.jpg", 16.95, LocalDate.now(), LocalDate.now().plusDays(1),"S021924", new Brand("9", "Simson"), pedalenCat, "simson-pedalen-sport-deluxe"));
			productRepository.save(new Product("17", 15L, "DHN", "Dahon pedalen opklapbaar/vouw oa Ciao, Vitesse, Roo, Curve D3", "Dahon pedalen opklapbaar/vouw oa Ciao, Vitesse, Roo, Curve D3\n" + "\n" + "Draadsoort    Normale draad\n" + "Geschikt voor    Volwassenen\n" + "Kleur    Zwart\n" + "Materiaal    Kunststof\n" + "Merk/Label    Dahon\n" + "Soort pedaal    Vouwpedaal\n" + "Type/Uitvoering    N.v.t.\n", "http://res.cloudinary.com/kantilever/image/upload/v1485269869/DAH6380010.jpg_xshuvu.jpg", 16.95, LocalDate.now(), LocalDate.now().plusDays(1),"DAH6380010", new Brand("10", "Dahon"), pedalenCat, "dahon-pedalen-opklapbaar-vouw-oa-ciao-vitesse-roo-curve-d3"));

			System.out.println("All products added");
			productRepository.findAll().forEach(System.out::println);
		};
	}
}
