package com.example.spring_crud_example_cities.service;

import com.example.spring_crud_example_cities.dto.CityDto;
import com.example.spring_crud_example_cities.exception.OurException;

import java.util.List;

public interface CityService {
    CityDto saveCity(CityDto cityDto) throws OurException;
    void deleteCity(Integer cityId);
    List<CityDto> findByName(String name);
    List<CityDto> findByCode(Integer code);
    List<CityDto> findAll();
}
