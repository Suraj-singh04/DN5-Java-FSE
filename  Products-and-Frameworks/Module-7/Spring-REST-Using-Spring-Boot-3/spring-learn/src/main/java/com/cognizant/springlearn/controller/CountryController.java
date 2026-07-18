package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public Country getCountry() {
        return new Country("IN", "India");
    }

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/countries/{code}")
    public Country getCountry( @PathVariable String code){
        return countryService.getCountry(code);
    }

    @PostMapping("/countries")
    public Country addCountry(@Valid @RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PutMapping("/countries/{code}")
    public Country updateCountry(
            @PathVariable String code,
            @Valid @RequestBody Country country) {

        return countryService.updateCountry(code, country);
    }

    @DeleteMapping("/countries/{code}")
    public String deleteCountry(
            @PathVariable String code) {

        return countryService.deleteCountry(code);

    }
    
}