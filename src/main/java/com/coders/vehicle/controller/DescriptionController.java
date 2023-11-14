package com.coders.vehicle.controller;

import com.coders.vehicle.dto.DescriptionDTO;
import com.coders.vehicle.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/description")
public class DescriptionController {
    private final DescriptionService descriptionService;

    @Autowired
    public DescriptionController(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }

    @GetMapping
    public List<DescriptionDTO> list() {
        return descriptionService.getAll();
    }

    @PostMapping("/add")
    public void addYear(@RequestBody DescriptionDTO descriptionDTO) {
        descriptionService.save(descriptionDTO);
    }

    @PutMapping("/update/{id}")
    public void updateYear(@PathVariable Integer id, @RequestBody DescriptionDTO descriptionDTO) {
        descriptionService.update(id, descriptionDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteYear(@PathVariable Integer id) {
        descriptionService.delete(id);
    }
}
