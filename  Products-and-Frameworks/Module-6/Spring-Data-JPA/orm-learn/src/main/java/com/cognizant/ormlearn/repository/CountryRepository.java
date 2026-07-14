package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.entity.Country;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CountryRepository extends JpaRepository<Country, String> {
    Country findByName(String name);

    @Query("SELECT c FROM Country c WHERE c.name = :name")
    Country getCountryByName(@Param("name") String name);

    List<Country> findByNameContaining(String name);
    List<Country> findByNameStartingWith(String prefix);
    List<Country> findByNameContainingOrderByNameAsc(String name);
}
