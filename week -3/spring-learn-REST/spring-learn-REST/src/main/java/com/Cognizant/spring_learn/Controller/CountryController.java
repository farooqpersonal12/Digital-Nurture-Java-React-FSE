package com.Cognizant.spring_learn.Controller;


import com.Cognizant.spring_learn.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


@RestController
public class CountryController {

    ApplicationContext context = new ClassPathXmlApplicationContext("Country.xml");
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @RequestMapping("/country")
    public Country getCountry(){
        LOGGER.info("GET_COUNTRY_METHOD_STARTED");
        Country country;
        country = (Country) context.getBean("in");
        LOGGER.info("GET_COUNTRY_METHOD_ENDED");
        return  country;
    }
    @GetMapping("/country/{id}")
    public Country getCountryByCode(@PathVariable String id) {
        LOGGER.info("GET_COUNTRY_BY_ID_STARTED");
        ArrayList<Country> countryList =
                (ArrayList<Country>) context.getBean("countryList");

        for (Country c : countryList) {
            if (c.getCode().equals(id)) {
                LOGGER.info("GET_COUNTRY_BY_ID_ENDED");
                return c;
            }
        }
        return null;
    }
}
