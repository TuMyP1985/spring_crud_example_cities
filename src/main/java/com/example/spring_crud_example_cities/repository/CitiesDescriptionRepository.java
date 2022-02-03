package com.example.spring_crud_example_cities.repository;

import com.example.spring_crud_example_cities.entity.CitiesDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CitiesDescriptionRepository extends JpaRepository<CitiesDescription,Integer> {

    @Query("SELECT u FROM CitiesDescription u WHERE u.city_id = :citiesDescriptionId")
    List<CitiesDescription> findByCityId(Integer citiesDescriptionId);
}
