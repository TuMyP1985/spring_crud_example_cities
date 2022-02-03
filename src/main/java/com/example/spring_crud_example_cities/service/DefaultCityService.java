package com.example.spring_crud_example_cities.service;

import com.example.spring_crud_example_cities.dto.CityDto;
import com.example.spring_crud_example_cities.entity.City;
import com.example.spring_crud_example_cities.exception.OurException;
import com.example.spring_crud_example_cities.repository.CitiesDescriptionRepository;
import com.example.spring_crud_example_cities.repository.CityRepository;
import com.example.spring_crud_example_cities.utility.Converter_City_Description;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DefaultCityService implements CityService {
    private final CityRepository cityRepository;
    private final CitiesDescriptionRepository citiesDescriptionRepository;
    private final Converter_City_Description converterCityDescription;

    @Override
    public CityDto saveCity(CityDto cityDto) throws OurException {
        validateCityDto(cityDto);
        City city = converterCityDescription.fromCityDtoToCity(cityDto);
        cityRepository.save(city);
        return converterCityDescription.fromCityToCityDto(city);
    }

    @Override
    public void deleteCity(Integer cityId) {
        cityRepository.deleteById(cityId);
        citiesDescriptionRepository.findByCityId(cityId).forEach(n->citiesDescriptionRepository.deleteById(n.getId()));
    }

    @Override
    public List<CityDto> findByName(String name) {
        List<City> cities = cityRepository.findByName(name);
        return converterCityDescription.resultProcessing(cities);
    }



    @Override
    public List<CityDto> findByCode(Integer code) {

        List<City> cities = cityRepository.findByCode(code);
        return converterCityDescription.resultProcessing(cities);

    }

    @Override
    public List<CityDto> findAll() {

        List<City> cities = cityRepository.findAll();
        return converterCityDescription.resultProcessing(cities);

    }



    private void validateCityDto(CityDto cityDto) throws OurException {
        if (cityDto == null) throw new OurException("city is empty!!");
        if (cityDto.getName() == null || cityDto.getName().isEmpty()) throw new OurException("city's name is empty!!");
    }
}
