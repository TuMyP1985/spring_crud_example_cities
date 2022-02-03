package com.example.spring_crud_example_cities.web;

import com.example.spring_crud_example_cities.dto.CityDto;
import com.example.spring_crud_example_cities.exception.OurException;
import com.example.spring_crud_example_cities.service.CityService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cities")
@Log
public class CityController {
    @Autowired
    private final CityService cityService;

    @PostMapping("/save")
    public CityDto saveCity(@RequestBody CityDto cityDto) throws OurException{
        log.info("Handling save CITY:"+cityDto);
        return cityService.saveCity(cityDto);
    }

    @GetMapping("/findAll")
    public List<CityDto> findAllCities() {
        log.info("Handling find all CITIES request");
        return cityService.findAll();
    }

    @GetMapping("/findByName")
    public List<CityDto> findByName(@RequestParam String name) {
        log.info("Handling find by CITY name request: " + name);
        return cityService.findByName(name);
    }

    @GetMapping("/findByCode")
    public List<CityDto> findByCode(@RequestParam String code){
        log.info("Handling find by CITY code request: " + code);
        int codeInt = code.matches("\\d+")?Integer.parseInt(code):0;
        return cityService.findByCode(codeInt);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCities(@PathVariable Integer id) {
        log.info("Handling delete CITY request: " + id);
        cityService.deleteCity(id);
        return ResponseEntity.ok().build();
    }
}
