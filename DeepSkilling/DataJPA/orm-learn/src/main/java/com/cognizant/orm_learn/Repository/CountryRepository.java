package com.cognizant.orm_learn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn.Model.Country;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Spring Data JPA auto-generates this from the method name
    Country findByCode(String code);

    static List<Country> findByNameContaining(String text) {
        return null;
    }

    // Same as above, sorted ascending by name
    static List<Country> findByNameContainingOrderByNameAsc(String text) {
        return null;
    }

    // Alphabet index - countries starting with given letter (e.g. "Z")
    static List<Country> findByNameStartingWith(String letter) {
        return null;
    }

}
