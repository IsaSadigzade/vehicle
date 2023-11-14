package com.coders.vehicle.controller;

import com.coders.vehicle.dto.EngineCapacityDTO;
import com.coders.vehicle.service.EngineCapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engine-capacity")
public class EngineCapacityController {
    private final EngineCapacityService engineCapacityService;

    @Autowired
    public EngineCapacityController(EngineCapacityService engineCapacityService) {
        this.engineCapacityService = engineCapacityService;
    }

    @GetMapping
    public List<EngineCapacityDTO> list() {
        return engineCapacityService.getAll();
    }

    @PostMapping("/add")
    public void addFuelType(@RequestBody EngineCapacityDTO engineCapacityDTO) {
        engineCapacityService.save(engineCapacityDTO);
    }

    @PutMapping("/update/{id}")
    public void updateFuelType(@PathVariable Integer id, @RequestBody EngineCapacityDTO engineCapacityDTO) {
        engineCapacityService.update(id, engineCapacityDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFuelType(@PathVariable Integer id) {
        engineCapacityService.delete(id);
    }
}
