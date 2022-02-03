package com.example.spring_crud_example_cities.web;

import com.example.spring_crud_example_cities.dto.CitiesDescriptionDto;
import com.example.spring_crud_example_cities.dto.CityDto;
import com.example.spring_crud_example_cities.exception.OurException;
import com.example.spring_crud_example_cities.service.CitiesDescriptionService;
import com.example.spring_crud_example_cities.service.CityService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/description")
@Log
public class CitiesDescriptionController {
    @Autowired
    private final CitiesDescriptionService citiesDescriptionService;

    @GetMapping("/findAll")
    public List<CitiesDescriptionDto> findAllDescriptions() {
        log.info("Handling find all Descriptions request");
        return citiesDescriptionService.findAll();
    }
    @GetMapping("/findByCityId")
    public List<CitiesDescriptionDto> findByCityId(@RequestParam String cityId){
        log.info("Handling find by Descriptions (city id) request: " + cityId);
        int codeInt = cityId.matches("\\d+")?Integer.parseInt(cityId):0;
        return citiesDescriptionService.findByCityId(codeInt);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDescriptions(@PathVariable Integer id) {
        log.info("Handling delete CITY request: " + id);
        citiesDescriptionService.deleteCitiesDescription(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/save")
    public CitiesDescriptionDto saveDescriptions(@RequestBody CitiesDescriptionDto citiesDescriptionDto) throws OurException {
        log.info("Handling save CITY:"+citiesDescriptionDto);
        return citiesDescriptionService.saveCitiesDescription(citiesDescriptionDto);
    }
}
