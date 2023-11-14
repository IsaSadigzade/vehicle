package com.coders.vehicle.service;

import com.coders.vehicle.dto.GearDTO;

import java.util.List;

public interface GearService {
    void save(GearDTO gearDTO);
    void update(Integer id, GearDTO gearDTO);
    void delete(Integer id);
    List<GearDTO> getAll();
}
