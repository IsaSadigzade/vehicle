package com.coders.vehicle.controller;

import com.coders.vehicle.dto.VehicleStatusDTO;
import com.coders.vehicle.service.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle-status")
public class VehicleStatusController {
    private final VehicleStatusService vehicleStatusService;

    @Autowired
    public VehicleStatusController(VehicleStatusService vehicleStatusService) {
        this.vehicleStatusService = vehicleStatusService;
    }

    @GetMapping
    public List<VehicleStatusDTO> list() {
        return vehicleStatusService.getAll();
    }

    @PostMapping("/add")
    public void addGear(@RequestBody VehicleStatusDTO vehicleStatusDTO) {
        vehicleStatusService.save(vehicleStatusDTO);
    }

    @PutMapping("/update/{id}")
    public void updateGear(@PathVariable Integer id, @RequestBody VehicleStatusDTO vehicleStatusDTO) {
        vehicleStatusService.update(id, vehicleStatusDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGear(@PathVariable Integer id) {
        vehicleStatusService.delete(id);
    }
}
