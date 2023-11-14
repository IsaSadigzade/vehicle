package com.coders.vehicle.controller;

import com.coders.vehicle.dto.EnginePowerDTO;
import com.coders.vehicle.service.EnginePowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engine-power")
public class EnginePowerController {
    private final EnginePowerService enginePowerService;

    @Autowired
    public EnginePowerController(EnginePowerService enginePowerService) {
        this.enginePowerService = enginePowerService;
    }

    @GetMapping
    public List<EnginePowerDTO> list() {
        return enginePowerService.getAll();
    }

    @PostMapping("/add")
    public void addFuelType(@RequestBody EnginePowerDTO enginePowerDTO) {
        enginePowerService.save(enginePowerDTO);
    }

    @PutMapping("/update/{id}")
    public void updateFuelType(@PathVariable Integer id, @RequestBody EnginePowerDTO enginePowerDTO) {
        enginePowerService.update(id, enginePowerDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFuelType(@PathVariable Integer id) {
        enginePowerService.delete(id);
    }
}
