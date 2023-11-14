package com.coders.vehicle.controller;

import com.coders.vehicle.dto.YearDTO;
import com.coders.vehicle.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/year")
public class YearController {
    private final YearService yearService;

    @Autowired
    public YearController(YearService yearService) {
        this.yearService = yearService;
    }

    @GetMapping
    public List<YearDTO> list() {
        return yearService.getAll();
    }

    @PostMapping("/add")
    public void addYear(@RequestBody YearDTO yearDTO) {
        yearService.save(yearDTO);
    }

    @PutMapping("/update/{id}")
    public void updateYear(@PathVariable Integer id, @RequestBody YearDTO yearDTO) {
        yearService.update(id, yearDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteYear(@PathVariable Integer id) {
        yearService.delete(id);
    }
}
