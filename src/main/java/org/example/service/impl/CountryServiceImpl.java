package org.example.service.impl;

import org.example.entity.Country;
import org.example.repository.CountryRepository;
import org.example.repository.impl.CountryRepositoryImpl;
import org.example.service.CountryService;

import java.util.List;

public class CountryServiceImpl implements CountryService {
    CountryRepository countryRepository = new CountryRepositoryImpl();
    @Override
    public String save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public String delete(Long id) {
        return countryRepository.delete(id);
    }


    @Override
    public void getCountries(List<Country>countries) {
         countryRepository.getCountries(countries);
    }
}
