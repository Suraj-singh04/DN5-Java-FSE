package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.entity.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public List<Country> getAllCountries() {

        return repository.findAll();

    }

    public Country getCountry(String name) {
        return repository.findByName(name);
    }

    public Country getCountryUsingQuery(String name) {
        return repository.getCountryByName(name);
    }

    public void getCountriesPage() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("name"));

        Page<Country> page = repository.findAll(pageable);

        page.getContent().forEach(System.out::println);
    }

    public List<Country> search(String text){
    return repository.findByNameContaining(text);
    }

    public List<Country> searchSorted(String text){
        return repository.findByNameContainingOrderByNameAsc(text);
    }

    public List<Country> startsWith(String text){
        return repository.findByNameStartingWith(text);
    }

}