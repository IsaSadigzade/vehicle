package com.coders.vehicle.service;

import com.coders.vehicle.dto.GearBoxDTO;
import com.coders.vehicle.entity.GearBoxEntity;

import java.util.List;

public interface GearBoxService {
    void save(GearBoxDTO gearBoxDTO);
    void update(Integer id, GearBoxDTO gearBoxDTO);
    void delete(Integer id);
    List<GearBoxDTO> getAll();
}
