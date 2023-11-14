package com.coders.vehicle.controller;

import com.coders.vehicle.dto.CarEquipmentDTO;
import com.coders.vehicle.service.CarEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car-equipments")
public class CarEquipmentController {
    private final CarEquipmentService carEquipmentService;

    @Autowired
    public CarEquipmentController(CarEquipmentService carEquipmentService) {
        this.carEquipmentService = carEquipmentService;
    }

    @GetMapping
    public List<CarEquipmentDTO> list() {
        return carEquipmentService.getAll();
    }

    @PostMapping("/add")
    public void addYear(@RequestBody CarEquipmentDTO carEquipmentDTO) {
        carEquipmentService.save(carEquipmentDTO);
    }

    @PutMapping("/update/{id}")
    public void updateYear(@PathVariable Integer id, @RequestBody CarEquipmentDTO carEquipmentDTO) {
        carEquipmentService.update(id, carEquipmentDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteYear(@PathVariable Integer id) {
        carEquipmentService.delete(id);
    }
}
