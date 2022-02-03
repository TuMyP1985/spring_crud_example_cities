package com.example.spring_crud_example_cities.utility;

import com.example.spring_crud_example_cities.dto.CitiesDescriptionDto;
import com.example.spring_crud_example_cities.dto.CityDto;
import com.example.spring_crud_example_cities.entity.CitiesDescription;
import com.example.spring_crud_example_cities.entity.City;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter_City_Description {
    public City fromCityDtoToCity(CityDto cityDto) {
        if (cityDto==null)
            return null;
        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        city.setCode(cityDto.getCode());
        city.setPopulation(cityDto.getPopulation());
        city.setFounded(cityDto.getFounded());

        return city;
    }

    public CityDto fromCityToCityDto(City city) {
        if (city==null)
            return null;
        return CityDto.builder()
                .id(city.getId())
                .code(city.getCode())
                .population(city.getPopulation())
                .founded(city.getFounded())
                .build();
    }

    public CitiesDescription fromcitiesDescriptionDtoTocitiesDescription(CitiesDescriptionDto citiesDescriptionDto) {
        if (citiesDescriptionDto==null)
            return null;
        CitiesDescription citiesDescription = new CitiesDescription();
        citiesDescription.setCity_id(citiesDescriptionDto.getCity_id());
        citiesDescription.setDescription(citiesDescriptionDto.getDescription());
        return citiesDescription;
    }

    public CitiesDescriptionDto fromcitiesDescriptionTocitiesDescriptionDto(CitiesDescription citiesDescription) {
        if (citiesDescription==null)
            return null;
        return CitiesDescriptionDto.builder()
                .id(citiesDescription.getId())
                .city_id(citiesDescription.getCity_id())
                .description(citiesDescription.getDescription())
                .build();
    }

    public List<CityDto> resultProcessing(List<City> cities){
        if (cities != null)
            return cities.stream().map(n -> CityDto.builder()
                            .id(n.getId())
                            .name(n.getName())
                            .code(n.getCode())
                            .population(n.getPopulation())
                            .founded(n.getFounded())
                            .build())
                    .collect(Collectors.toList());
        return null;
    }
    public List<CitiesDescriptionDto> resultProcessingCitiesDescription(List<CitiesDescription> cities){
        if (cities != null)
            return cities.stream().map(n -> CitiesDescriptionDto.builder()
                            .id(n.getId())
                            .city_id(n.getCity_id())
                            .description(n.getDescription())
                            .build())
                    .collect(Collectors.toList());
        return null;
    }
}
