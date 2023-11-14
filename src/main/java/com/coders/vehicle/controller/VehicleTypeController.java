package com.coders.vehicle.controller;

import com.coders.vehicle.dto.VehicleTypeDTO;
import com.coders.vehicle.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle-type")
public class VehicleTypeController {
    private final VehicleTypeService vehicleTypeService;

    @Autowired
    public VehicleTypeController(VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }

    @GetMapping
    public List<VehicleTypeDTO> list() {
        return vehicleTypeService.getAll();
    }

    @PostMapping("/add")
    public void addGear(@RequestBody VehicleTypeDTO vehicleTypeDTO) {
        vehicleTypeService.save(vehicleTypeDTO);
    }

    @PutMapping("/update/{id}")
    public void updateGear(@PathVariable Integer id, @RequestBody VehicleTypeDTO vehicleTypeDTO) {
        vehicleTypeService.update(id, vehicleTypeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGear(@PathVariable Integer id) {
        vehicleTypeService.delete(id);
    }
}
