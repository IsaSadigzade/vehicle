package com.coders.vehicle.controller;

import com.coders.vehicle.entity.FuelTypeEntity;
import com.coders.vehicle.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fuel-type")
public class FuelTypeController {

    private final FuelTypeService fuelTypeService;

    @Autowired
    public FuelTypeController(FuelTypeService fuelTypeService) {
        this.fuelTypeService = fuelTypeService;
    }

    @GetMapping
    public List<FuelTypeEntity> list() {
        return fuelTypeService.getAll();
    }

    @PostMapping("/add")
    public void addFuelType(@RequestBody FuelTypeEntity fuelType) {
        fuelTypeService.save(fuelType);
    }

    @PutMapping("/update/{id}")
    public void updateFuelType(@PathVariable Integer id, @RequestBody FuelTypeEntity fuelType) {
        fuelTypeService.update(id, fuelType);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFuelType(@PathVariable Integer id) {
        fuelTypeService.delete(id);
    }
}
