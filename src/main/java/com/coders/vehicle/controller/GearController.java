package com.coders.vehicle.controller;

import com.coders.vehicle.entity.GearEntity;
import com.coders.vehicle.service.GearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gear")
public class GearController {

    @Autowired
    private GearService gearService;

    @GetMapping
    public List<GearEntity> list() {
        return gearService.getAll();
    }

    @PostMapping("/add")
    public void addGear(@RequestBody GearEntity gear) {
        gearService.save(gear);
    }

    @PutMapping("/update/{id}")
    public void updateGear(@PathVariable Integer id, @RequestBody GearEntity gear) {
        gearService.update(id, gear);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGear(@PathVariable Integer id) {
        gearService.delete(id);
    }
}
