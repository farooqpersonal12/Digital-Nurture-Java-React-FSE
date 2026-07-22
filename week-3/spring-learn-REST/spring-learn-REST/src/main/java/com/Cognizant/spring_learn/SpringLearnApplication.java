package com.Cognizant.spring_learn;

import com.Cognizant.spring_learn.Controller.CountryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws ParseException {

		SpringApplication.run(SpringLearnApplication.class, args);

		LOGGER.info("Application started successfully");

//		displayDate();
//		DisplayCountries();

	}

	static void displayDate() throws ParseException {

		ApplicationContext context =
				new ClassPathXmlApplicationContext("Date_Formate.xml");

		SimpleDateFormat format =
				context.getBean("dateFormat", SimpleDateFormat.class);

		Date date = format.parse("31/12/2018");

		System.out.println("Today's Date: " + format.format(date));
	}

	static void DisplayCountries() {

		LOGGER.info("Start");

		ApplicationContext context =
				new ClassPathXmlApplicationContext("Country.xml");

		ArrayList<Country> countries =
				(ArrayList<Country>) context.getBean("countryList");

		LOGGER.debug("Countries:");
		for (Country country : countries) {
			System.out.println(country);
		}
	}
}