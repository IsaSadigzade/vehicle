package com.coders.vehicle.controller;

import com.coders.vehicle.dto.CreditAndBarterDTO;
import com.coders.vehicle.service.CreditAndBarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit-and-barter")
public class CreditAndBarterController {
    private final CreditAndBarterService creditAndBarterService;

    @Autowired
    public CreditAndBarterController(CreditAndBarterService creditAndBarterService) {
        this.creditAndBarterService = creditAndBarterService;
    }

    @GetMapping
    public List<CreditAndBarterDTO> list() {
        return creditAndBarterService.getAll();
    }

    @PostMapping("/add")
    public void addYear(@RequestBody CreditAndBarterDTO creditAndBarterDTO) {
        creditAndBarterService.save(creditAndBarterDTO);
    }

    @PutMapping("/update/{id}")
    public void updateYear(@PathVariable Integer id, @RequestBody CreditAndBarterDTO creditAndBarterDTO) {
        creditAndBarterService.update(id, creditAndBarterDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteYear(@PathVariable Integer id) {
        creditAndBarterService.delete(id);
    }
}
