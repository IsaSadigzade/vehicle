package com.coders.vehicle.controller;

import com.coders.vehicle.dto.BrandDTO;
import com.coders.vehicle.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<BrandDTO> list() {
        return brandService.getAll();
    }

    @PostMapping("/add")
    public void addYear(@RequestBody BrandDTO brandDTO) {
        brandService.save(brandDTO);
    }

    @PutMapping("/update/{id}")
    public void updateYear(@PathVariable Integer id, @RequestBody BrandDTO brandDTO) {
        brandService.update(id, brandDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteYear(@PathVariable Integer id) {
        brandService.delete(id);
    }
}
