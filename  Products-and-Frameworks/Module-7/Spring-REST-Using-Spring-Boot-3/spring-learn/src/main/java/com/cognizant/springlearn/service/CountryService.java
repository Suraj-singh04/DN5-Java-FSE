package com.cognizant.springlearn.service;

import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.model.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}