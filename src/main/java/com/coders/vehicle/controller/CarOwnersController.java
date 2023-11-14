package com.coders.vehicle.controller;

import com.coders.vehicle.dto.CarOwnersDTO;
import com.coders.vehicle.service.CarOwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car-owners")
public class CarOwnersController {
    private final CarOwnersService carOwnersService;

    @Autowired
    public CarOwnersController(CarOwnersService carOwnersService) {
        this.carOwnersService = carOwnersService;
    }

    @GetMapping
    public List<CarOwnersDTO> list() {
        return carOwnersService.getAll();
    }

    @PostMapping("/add")
    public void addGear(@RequestBody CarOwnersDTO carOwnersDTO) {
        carOwnersService.save(carOwnersDTO);
    }

    @PutMapping("/update/{id}")
    public void updateGear(@PathVariable Integer id, @RequestBody CarOwnersDTO carOwnersDTO) {
        carOwnersService.update(id, carOwnersDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGear(@PathVariable Integer id) {
        carOwnersService.delete(id);
    }
}
