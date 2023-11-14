package com.coders.vehicle.controller;

import com.coders.vehicle.dto.CarMileageDTO;
import com.coders.vehicle.service.CarMileageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car-mileage")
public class CarMileageController {
    private final CarMileageService carMileageService;

    @Autowired
    public CarMileageController(CarMileageService carMileageService) {
        this.carMileageService = carMileageService;
    }

    @GetMapping
    public List<CarMileageDTO> list() {
        return carMileageService.getAll();
    }

    @PostMapping("/add")
    public void addGear(@RequestBody CarMileageDTO carMileageDTO) {
        carMileageService.save(carMileageDTO);
    }

    @PutMapping("/update/{id}")
    public void updateGear(@PathVariable Integer id, @RequestBody CarMileageDTO carMileageDTO) {
        carMileageService.update(id, carMileageDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGear(@PathVariable Integer id) {
        carMileageService.delete(id);
    }
}
