package com.example.spring_crud_example_cities.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cities_descriptions")
@NoArgsConstructor
@Data
public class CitiesDescription {
    @Column
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer city_id;
    @Column
    private String description;


}
