package com.cognizant.ormlearn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormlearn.entity.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {
	@Autowired
	private CountryService countryService;

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
	}

}
