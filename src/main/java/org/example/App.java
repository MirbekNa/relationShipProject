package org.example;

import org.example.entity.Country;
import org.example.entity.President;
import org.example.hibernateCon.HiberCon;
import org.example.service.CountryService;
import org.example.service.PresidentService;
import org.example.service.impl.CountryServiceImpl;
import org.example.service.impl.PresidentServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CountryService countryService = new CountryServiceImpl();
        PresidentService presidentService=new PresidentServiceImpl();

        List<Country>countries=new ArrayList<>();
        countryService.getCountries(countries);
    }
}
