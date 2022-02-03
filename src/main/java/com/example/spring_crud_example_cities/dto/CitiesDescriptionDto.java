package com.example.spring_crud_example_cities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Data
@Builder
public class CitiesDescriptionDto {
    private Integer id;
    private Integer city_id;
    private String description;
}
