package com.coders.vehicle.controller;

import com.coders.vehicle.dto.ColourDTO;
import com.coders.vehicle.service.ColourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colour")
public class ColourController {
    private final ColourService colourService;

    @Autowired
    public ColourController(ColourService colourService) {
        this.colourService = colourService;
    }

    @GetMapping
    public List<ColourDTO> list() {
        return colourService.getAll();
    }

    @PostMapping("/add")
    public void addYear(@RequestBody ColourDTO colourDTO) {
        colourService.save(colourDTO);
    }

    @PutMapping("/update/{id}")
    public void updateYear(@PathVariable Integer id, @RequestBody ColourDTO colourDTO) {
        colourService.update(id, colourDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteYear(@PathVariable Integer id) {
        colourService.delete(id);
    }
}
