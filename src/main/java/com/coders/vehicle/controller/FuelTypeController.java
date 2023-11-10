package com.coders.vehicle.controller;

import com.coders.vehicle.dto.FuelTypeDTO;
import com.coders.vehicle.entity.FuelTypeEntity;
import com.coders.vehicle.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<FuelTypeDTO> list() {
        return fuelTypeService.getAll();
    }

    @PostMapping("/add")
    public void addFuelType(@RequestBody FuelTypeDTO fuelTypeDTO) {
        fuelTypeService.save(fuelTypeDTO);
    }

    @PutMapping("/update/{id}")
    public void updateFuelType(@PathVariable Integer id, @RequestBody FuelTypeDTO fuelTypeDTO) {
        fuelTypeService.update(id, fuelTypeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFuelType(@PathVariable Integer id) {
        fuelTypeService.delete(id);
    }
}
