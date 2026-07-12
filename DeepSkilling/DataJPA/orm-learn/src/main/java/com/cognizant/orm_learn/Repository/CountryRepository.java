package com.cognizant.orm_learn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn.Model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Spring Data JPA auto-generates this from the method name
    Country findByCode(String code);

}
