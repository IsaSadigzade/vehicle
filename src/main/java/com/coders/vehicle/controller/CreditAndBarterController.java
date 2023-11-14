package com.coders.vehicle.controller;

import com.coders.vehicle.dto.ExtrasDTO;
import com.coders.vehicle.service.ExtrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/extras")
public class ExtrasController {
    private final ExtrasService extrasService;

    @Autowired
    public ExtrasController(ExtrasService extrasService) {
        this.extrasService = extrasService;
    }

    @GetMapping
    public List<ExtrasDTO> list() {
        return extrasService.getAll();
    }

    @PostMapping("/add")
    public void addYear(@RequestBody ExtrasDTO extrasDTO) {
        extrasService.save(extrasDTO);
    }

    @PutMapping("/update/{id}")
    public void updateYear(@PathVariable Integer id, @RequestBody ExtrasDTO extrasDTO) {
        extrasService.update(id, extrasDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteYear(@PathVariable Integer id) {
        extrasService.delete(id);
    }
}
