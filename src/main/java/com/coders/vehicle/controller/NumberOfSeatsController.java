package com.coders.vehicle.controller;

import com.coders.vehicle.dto.NumberOfSeatsDTO;
import com.coders.vehicle.service.NumberOfSeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/number-of-seats")
public class NumberOfSeatsController {
    private final NumberOfSeatsService numberOfSeatsService;

    @Autowired
    public NumberOfSeatsController(NumberOfSeatsService numberOfSeatsService) {
        this.numberOfSeatsService = numberOfSeatsService;
    }

    @GetMapping
    public List<NumberOfSeatsDTO> list() {
        return numberOfSeatsService.getAll();
    }

    @PostMapping("/add")
    public void addGear(@RequestBody NumberOfSeatsDTO numberOfSeatsDTO) {
        numberOfSeatsService.save(numberOfSeatsDTO);
    }

    @PutMapping("/update/{id}")
    public void updateGear(@PathVariable Integer id, @RequestBody NumberOfSeatsDTO numberOfSeatsDTO) {
        numberOfSeatsService.update(id, numberOfSeatsDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGear(@PathVariable Integer id) {
        numberOfSeatsService.delete(id);
    }
}
