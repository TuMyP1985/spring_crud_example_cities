package com.example.spring_crud_example_cities.repository;

import com.example.spring_crud_example_cities.dto.CityDto;
import com.example.spring_crud_example_cities.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Integer> {
    List<City> findByName(String name);
    List<City> findByCode(Integer code);
}
