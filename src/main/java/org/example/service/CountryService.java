package org.example.service;

import org.example.entity.Country;
import org.example.repository.CountryRepository;

import java.util.List;

public interface CountryService  {
    String save (Country country);
    String delete(Long id);
    void getCountries(List<Country>countries);
}
