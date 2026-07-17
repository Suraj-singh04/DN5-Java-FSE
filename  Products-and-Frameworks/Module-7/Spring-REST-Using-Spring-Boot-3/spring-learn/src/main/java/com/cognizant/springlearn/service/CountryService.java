package com.cognizant.springlearn.service;

import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.model.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CountryService {

    private List<Country> countries = new ArrayList<>();

     public CountryService() {
        countries.add(new Country("IN", "India"));
        countries.add(new Country("US", "United States"));
        countries.add(new Country("JP", "Japan"));
        countries.add(new Country("DE", "Germany"));
    }

    public List<Country> getAllCountries() {
        return countries;
    }


    public Country getCountry(String code) {

        return getAllCountries()
                .stream()
                .filter(country ->
                        country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country not found"));

    }

    public Country addCountry(Country country) {
        countries.add(country);
        return country;
    }

    public Country updateCountry(String code, Country updatedCountry) {
        for (Country country : countries) {

            if (country.getCode().equalsIgnoreCase(code)) {

                country.setName(updatedCountry.getName());

                return country;
            }
        }

        throw new CountryNotFoundException("Country not found");
    }

    public String deleteCountry(String code) {

        Iterator<Country> iterator = countries.iterator();

        while (iterator.hasNext()) {

            Country country = iterator.next();

            if (country.getCode().equalsIgnoreCase(code)) {

                iterator.remove();

                return "Country deleted successfully";
            }
        }

        throw new CountryNotFoundException("Country not found");
    }
    
}