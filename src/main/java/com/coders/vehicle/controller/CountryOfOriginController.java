package com.coders.vehicle.controller;

import com.coders.vehicle.dto.CountryOfOriginDTO;
import com.coders.vehicle.service.CountryOfOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country-of-origin")
public class CountryOfOriginController {
    private final CountryOfOriginService countryOfOriginService;

    @Autowired
    public CountryOfOriginController(CountryOfOriginService countryOfOriginService) {
        this.countryOfOriginService = countryOfOriginService;
    }

    @GetMapping
    public List<CountryOfOriginDTO> list() {
        return countryOfOriginService.getAll();
    }

    @PostMapping("/add")
    public void addFuelType(@RequestBody CountryOfOriginDTO countryOfOriginDTO) {
        countryOfOriginService.save(countryOfOriginDTO);
    }

    @PutMapping("/update/{id}")
    public void updateFuelType(@PathVariable Integer id, @RequestBody CountryOfOriginDTO countryOfOriginDTO) {
        countryOfOriginService.update(id, countryOfOriginDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFuelType(@PathVariable Integer id) {
        countryOfOriginService.delete(id);
    }
}
