package com.coders.vehicle.controller;

import com.coders.vehicle.dto.GearDTO;
import com.coders.vehicle.service.GearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gear")
public class GearController {

    private final GearService gearService;

    @Autowired
    public GearController(GearService gearService) {
        this.gearService = gearService;
    }

    @GetMapping
    public List<GearDTO> list() {
        return gearService.getAll();
    }

    @PostMapping("/add")
    public void addGear(@RequestBody GearDTO gearDTO) {
        gearService.save(gearDTO);
    }

    @PutMapping("/update/{id}")
    public void updateGear(@PathVariable Integer id, @RequestBody GearDTO gearDTO) {
        gearService.update(id, gearDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGear(@PathVariable Integer id) {
        gearService.delete(id);
    }
}
