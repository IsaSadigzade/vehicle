package com.coders.vehicle.controller;

import com.coders.vehicle.dto.VinCodeDTO;
import com.coders.vehicle.service.VinCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vin-code")
public class VinCodeController {
    private final VinCodeService vinCodeService;

    @Autowired
    public VinCodeController(VinCodeService vinCodeService) {
        this.vinCodeService = vinCodeService;
    }

    @GetMapping
    public List<VinCodeDTO> list() {
        return vinCodeService.getAll();
    }

    @PostMapping("/add")
    public void addYear(@RequestBody VinCodeDTO vinCodeDTO) {
        vinCodeService.save(vinCodeDTO);
    }

    @PutMapping("/update/{id}")
    public void updateYear(@PathVariable Integer id, @RequestBody VinCodeDTO vinCodeDTO) {
        vinCodeService.update(id, vinCodeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteYear(@PathVariable Integer id) {
        vinCodeService.delete(id);
    }
}
