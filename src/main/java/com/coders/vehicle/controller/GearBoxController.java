package com.coders.vehicle.controller;

import com.coders.vehicle.entity.GearBoxEntity;
import com.coders.vehicle.service.GearBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gear-box")
public class GearBoxController {
    @Autowired
    private GearBoxService gearBoxService;

    @GetMapping
    public List<GearBoxEntity> list() {
        return gearBoxService.getAll();
    }

    @PostMapping("/add")
    public void addGearBox(@RequestBody GearBoxEntity gearBox) {
        gearBoxService.save(gearBox);
    }

    @PutMapping("/update/{id}")
    public void updateGearBox(@PathVariable Integer id, @RequestBody GearBoxEntity gearBox) {
        gearBoxService.update(id, gearBox);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGearBox(@PathVariable Integer id) {
        gearBoxService.delete(id);
    }
}
