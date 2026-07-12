package com.cognizant.orm_learn;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.Model.Country;
import com.cognizant.orm_learn.Service.CountryService;


@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main");

		countryService = context.getBean(CountryService.class);

		testGetAllCountries();
		testGetCountryByCode();
		testAddCountry();
		testGetAllCountries(); // to verify the new country was added
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start - testGetAllCountries");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End - testGetAllCountries");
	}

	private static void testGetCountryByCode() {
		LOGGER.info("Start - testGetCountryByCode");
		Country country = countryService.getCountryByCode("IN");
		LOGGER.debug("country={}", country);
		LOGGER.info("End - testGetCountryByCode");
	}

	private static void testAddCountry() {
		LOGGER.info("Start - testAddCountry");
		Country country = new Country("UK", "United Kingdom");
		Country savedCountry = countryService.addCountry(country);
		LOGGER.debug("savedCountry={}", savedCountry);
		LOGGER.info("End - testAddCountry");
	}

}