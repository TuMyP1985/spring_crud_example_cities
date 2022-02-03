package com.example.spring_crud_example_cities.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cities")
@NoArgsConstructor
@Data
public class City {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private Integer code;
    @Column
    private String name;
    @Column
    private Integer population;
    @Column
    private LocalDate founded;
}
