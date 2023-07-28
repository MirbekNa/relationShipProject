package org.example.repository;

import org.example.entity.Country;

import java.util.List;

public interface CountryRepository {
    String save(Country country);

    String delete(Long id);
     void getCountries(List<Country>countries);
}
