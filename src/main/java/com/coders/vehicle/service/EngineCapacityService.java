package com.coders.vehicle.service;

import com.coders.vehicle.dto.EngineCapacityDTO;

import java.util.List;

public interface EngineCapacityService {
    void save(EngineCapacityDTO engineCapacityDTO);

    void update(Integer id, EngineCapacityDTO engineCapacityDTO);

    void delete(Integer id);

    List<EngineCapacityDTO> getAll();
}
