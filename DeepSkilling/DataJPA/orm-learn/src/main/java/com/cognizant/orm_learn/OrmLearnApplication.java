package com.cognizant.orm_learn;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.cognizant.orm_learn.Model.*;
import com.cognizant.orm_learn.Repository.CountryRepository;
import com.cognizant.orm_learn.Repository.StockRepository;
import com.cognizant.orm_learn.Service.DepartmentService;
import com.cognizant.orm_learn.Service.EmployeeService;
import com.cognizant.orm_learn.Service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.Service.CountryService;


@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;


	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;


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

	private static void testCountryQueryMethods() {
		LOGGER.info("Start - testCountryQueryMethods");

		List<Country> containing = CountryRepository.findByNameContaining("ou");
		LOGGER.debug("Countries containing 'ou': {}", containing);

		List<Country> containingSorted = CountryRepository.findByNameContainingOrderByNameAsc("ou");
		LOGGER.debug("Countries containing 'ou' sorted: {}", containingSorted);

		List<Country> startingWithZ = CountryRepository.findByNameStartingWith("Z");
		LOGGER.debug("Countries starting with 'Z': {}", startingWithZ);

		LOGGER.info("End - testCountryQueryMethods");
	}

	private static void testStockQueryMethods() throws ParseException {
		LOGGER.info("Start - testStockQueryMethods");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date sepStart = sdf.parse("2019-09-01");
		Date sepEnd = sdf.parse("2019-09-30");
		List<Stock> fbSeptember = StockRepository.findByCodeAndDateBetween("FB", sepStart, sepEnd);
		LOGGER.debug("FB September 2019 stocks: {}", fbSeptember);

		List<Stock> googleHigh = StockRepository.findByCodeAndCloseGreaterThan("GOOGL", 1250.0);
		LOGGER.debug("Google stocks > 1250: {}", googleHigh);

		List<Stock> topVolume = StockRepository.findTop3ByOrderByVolumeDesc();
		LOGGER.debug("Top 3 highest volume: {}", topVolume);

		List<Stock> nflxLowest = StockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
		LOGGER.debug("Netflix lowest 3: {}", nflxLowest);

		LOGGER.info("End - testStockQueryMethods");
	}


// In main(): assign each from context, same pattern as countryService

	private static void testGetEmployee() {
		LOGGER.info("Start");
		com.cognizant.orm_learn.Model.Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");
	}

	private static void testAddEmployee() {
		LOGGER.info("Start");
		Employee employee = new Employee();
		employee.setName("John Doe");
		employee.setSalary(50000.0);
		employee.setPermanent(true);
		employee.setDateOfBirth(new Date());

		com.cognizant.orm_learn.Model.Department department = departmentService.get(1);
		employee.setDepartment(department);

		employeeService.save(employee);
		LOGGER.debug("Saved Employee:{}", employee);
		LOGGER.info("End");
	}

	private static void testUpdateEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);

		Department newDepartment = departmentService.get(2);
		employee.setDepartment(newDepartment);

		employeeService.save(employee);
		LOGGER.debug("Updated Employee:{}", employee);
		LOGGER.info("End");
	}

	private static void testGetDepartment() {
		LOGGER.info("Start");
		Department department = departmentService.get(1);
		LOGGER.debug("Department:{}", department);
		LOGGER.debug("EmployeeList:{}", department.getEmployeeList());
		LOGGER.info("End");
	}

	private static void testAddSkillToEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(2);
		Skill skill = skillService.get(3);

		employee.getSkillList().add(skill);
		employeeService.save(employee);

		LOGGER.debug("Employee after adding skill:{}", employee);
		LOGGER.info("End");
	}

}