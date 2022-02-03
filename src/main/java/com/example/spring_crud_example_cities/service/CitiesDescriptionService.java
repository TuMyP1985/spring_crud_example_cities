package com.example.spring_crud_example_cities.service;

import com.example.spring_crud_example_cities.dto.CitiesDescriptionDto;
import com.example.spring_crud_example_cities.dto.CityDto;
import com.example.spring_crud_example_cities.exception.OurException;

import java.util.List;

public interface CitiesDescriptionService {
    CitiesDescriptionDto saveCitiesDescription(CitiesDescriptionDto citiesDescriptionDto) throws OurException;
    void deleteCitiesDescription(Integer citiesDescriptionId);
    List<CitiesDescriptionDto> findByCityId(Integer citiesDescriptionId);
    List<CitiesDescriptionDto> findAll();
}
