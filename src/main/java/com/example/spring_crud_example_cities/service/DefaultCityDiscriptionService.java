package com.example.spring_crud_example_cities.service;

import com.example.spring_crud_example_cities.dto.CitiesDescriptionDto;
import com.example.spring_crud_example_cities.dto.CityDto;
import com.example.spring_crud_example_cities.entity.CitiesDescription;
import com.example.spring_crud_example_cities.entity.City;
import com.example.spring_crud_example_cities.exception.OurException;
import com.example.spring_crud_example_cities.repository.CitiesDescriptionRepository;
import com.example.spring_crud_example_cities.repository.CityRepository;
import com.example.spring_crud_example_cities.utility.Converter_City_Description;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class DefaultCityDiscriptionService implements CitiesDescriptionService {
    private final CitiesDescriptionRepository citiesDescriptionRepository;
    private final Converter_City_Description converterCityDescription;



    private void validateCitiesDescriptionDto(CitiesDescriptionDto citiesDescriptionDto) throws OurException {
        if (citiesDescriptionDto == null) throw new OurException("city is empty!!");
        if (citiesDescriptionDto.getDescription() == null || citiesDescriptionDto.getDescription().isEmpty()) throw new OurException("city's description is empty!!");
    }

    @Override
    public CitiesDescriptionDto saveCitiesDescription(CitiesDescriptionDto citiesDescriptionDto) throws OurException {
        validateCitiesDescriptionDto(citiesDescriptionDto);
        CitiesDescription citiesDescription = converterCityDescription.fromcitiesDescriptionDtoTocitiesDescription(citiesDescriptionDto);
        citiesDescriptionRepository.save(citiesDescription);
        return converterCityDescription.fromcitiesDescriptionTocitiesDescriptionDto(citiesDescription);
    }

    @Override
    public void deleteCitiesDescription(Integer citiesDescriptionId) {
        citiesDescriptionRepository.deleteById(citiesDescriptionId);
    }

    @Override
    public List<CitiesDescriptionDto> findByCityId(Integer citiesDescriptionId) {
        List<CitiesDescription> cities = citiesDescriptionRepository.findByCityId(citiesDescriptionId);
        return converterCityDescription.resultProcessingCitiesDescription(cities);
    }

    @Override
    public List<CitiesDescriptionDto> findAll() {
        List<CitiesDescription> cities = citiesDescriptionRepository.findAll();
        return converterCityDescription.resultProcessingCitiesDescription(cities);
    }

}
