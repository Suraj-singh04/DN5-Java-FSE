package com.cognizant.ormlearn;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormlearn.entity.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.StockService;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {
	@Autowired
	private CountryService countryService;

	@Autowired
	private StockService stockService;

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}

	public void run(String... args) {
		List<Country> countries = countryService.getAllCountries();
		countries.forEach(System.out::println);

		// System.out.println("---------------------------------");
		
		// Country country = countryService.getCountry("India");

		// System.out.println(country);

		// System.out.println("Using @Query");

		// Country country = countryService.getCountryUsingQuery("India");

		// System.out.println(country);

		System.out.println("Using Pagination");

		countryService.getCountriesPage();

		System.out.println("Containing");

		countryService.search("an")
					.forEach(System.out::println);

		System.out.println();

		System.out.println("Sorted");

		countryService.searchSorted("an")
					.forEach(System.out::println);

		System.out.println();

		System.out.println("Starts With");

		countryService.startsWith("I")
					.forEach(System.out::println);


		System.out.println("\nFacebook Stocks");
		stockService.getFacebookStocks()
				.forEach(System.out::println);

		System.out.println("\nStocks on 2024-01-01");
		stockService.getStocksOnDate(LocalDate.parse("2024-01-01"))
				.forEach(System.out::println);

		System.out.println("\nClosing Price > 300");
		stockService.getHighClosingStocks()
				.forEach(System.out::println);

		System.out.println("\nTop 3 Volumes");
		stockService.getTopVolumes()
				.forEach(System.out::println);
	}

}
