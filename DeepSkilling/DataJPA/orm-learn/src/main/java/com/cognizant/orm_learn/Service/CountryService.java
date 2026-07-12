package com.cognizant.orm_learn.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.orm_learn.Model.Country;
import com.cognizant.orm_learn.Repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country getCountryByCode(String code) {
        return countryRepository.findByCode(code);
    }

    @Transactional
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }
}