package com.coders.vehicle.controller;

import com.coders.vehicle.dto.GearBoxDTO;
import com.coders.vehicle.service.GearBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gear-box")
public class GearBoxController {
    private final GearBoxService gearBoxService;

    @Autowired
    public GearBoxController(GearBoxService gearBoxService) {
        this.gearBoxService = gearBoxService;
    }

    @GetMapping
    public List<GearBoxDTO> list() {
        return gearBoxService.getAll();
    }

    @PostMapping("/add")
    public void addGearBox(@RequestBody GearBoxDTO gearBoxDTO) {
        gearBoxService.save(gearBoxDTO);
    }

    @PutMapping("/update/{id}")
    public void updateGearBox(@PathVariable Integer id, @RequestBody GearBoxDTO gearBoxDTO) {
        gearBoxService.update(id, gearBoxDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGearBox(@PathVariable Integer id) {
        gearBoxService.delete(id);
    }
}
