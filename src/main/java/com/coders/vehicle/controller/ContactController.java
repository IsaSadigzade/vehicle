package com.coders.vehicle.controller;

import com.coders.vehicle.dto.ContactDTO;
import com.coders.vehicle.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<ContactDTO> list() {
        return contactService.getAll();
    }

    @PostMapping("/add")
    public void addYear(@RequestBody ContactDTO contactDTO) {
        contactService.save(contactDTO);
    }

    @PutMapping("/update/{id}")
    public void updateYear(@PathVariable Integer id, @RequestBody ContactDTO contactDTO) {
        contactService.update(id, contactDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteYear(@PathVariable Integer id) {
        contactService.delete(id);
    }
}
