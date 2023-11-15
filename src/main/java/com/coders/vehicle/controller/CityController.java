package com.coders.vehicle.controller;

import com.coders.vehicle.dto.CityDTO;
import com.coders.vehicle.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<CityDTO> list() {
        return cityService.getAll();
    }

    @PostMapping("/add")
    public void addYear(@RequestBody CityDTO cityDTO) {
        cityService.save(cityDTO);
    }

    @PutMapping("/update/{id}")
    public void updateYear(@PathVariable Integer id, @RequestBody CityDTO cityDTO) {
        cityService.update(id, cityDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteYear(@PathVariable Integer id) {
        cityService.delete(id);
    }
}
