package com.coders.vehicle.controller;

import com.coders.vehicle.dto.VehicleDTO;
import com.coders.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<VehicleDTO> list() {
        return vehicleService.getAll();
    }

    @PostMapping("/add")
    public void addYear(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.save(vehicleDTO);
    }

    @PutMapping("/update/{id}")
    public void updateYear(@PathVariable Integer id, @RequestBody VehicleDTO vehicleDTO) {
        vehicleService.update(id, vehicleDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteYear(@PathVariable Integer id) {
        vehicleService.delete(id);
    }
}
