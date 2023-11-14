package com.coders.vehicle.controller;

import com.coders.vehicle.dto.PriceDTO;
import com.coders.vehicle.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {
    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public List<PriceDTO> list() {
        return priceService.getAll();
    }

    @PostMapping("/add")
    public void addYear(@RequestBody PriceDTO priceDTO) {
        priceService.save(priceDTO);
    }

    @PutMapping("/update/{id}")
    public void updateYear(@PathVariable Integer id, @RequestBody PriceDTO priceDTO) {
        priceService.update(id, priceDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteYear(@PathVariable Integer id) {
        priceService.delete(id);
    }
}
