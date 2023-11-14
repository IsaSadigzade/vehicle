package com.coders.vehicle.service;

import com.coders.vehicle.dto.ExtrasDTO;

import java.util.List;

public interface ExtrasService {
    void save(ExtrasDTO extrasDTO);

    void update(Integer id, ExtrasDTO extrasDTO);

    void delete(Integer id);

    List<ExtrasDTO> getAll();
}
