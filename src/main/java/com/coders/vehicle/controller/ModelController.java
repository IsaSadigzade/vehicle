package com.coders.vehicle.controller;

import com.coders.vehicle.dto.ModelDTO;
import com.coders.vehicle.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {
    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public List<ModelDTO> list() {
        return modelService.getAll();
    }

    @PostMapping("/add")
    public void addYear(@RequestBody ModelDTO modelDTO) {
        modelService.save(modelDTO);
    }

    @PutMapping("/update/{id}")
    public void updateYear(@PathVariable Integer id, @RequestBody ModelDTO modelDTO) {
        modelService.update(id, modelDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteYear(@PathVariable Integer id) {
        modelService.delete(id);
    }
}
