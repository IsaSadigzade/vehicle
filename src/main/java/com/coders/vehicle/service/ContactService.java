package com.coders.vehicle.service;

import com.coders.vehicle.dto.ContactDTO;

import java.util.List;

public interface ContactService {
    void save(ContactDTO contactDTO);

    void update(Integer id, ContactDTO contactDTO);

    void delete(Integer id);

    List<ContactDTO> getAll();
}
