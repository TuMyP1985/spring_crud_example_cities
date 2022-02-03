package com.example.spring_crud_example_cities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@Data
@Builder
public class CityDto {
    private Integer id;
    private Integer code;
    private String name;
    private Integer population;
    private LocalDate founded;
}
