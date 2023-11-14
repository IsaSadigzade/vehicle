package com.coders.vehicle.service;

import com.coders.vehicle.dto.EnginePowerDTO;

import java.util.List;

public interface EnginePowerService {
    void save(EnginePowerDTO enginePowerDTO);

    void update(Integer id, EnginePowerDTO enginePowerDTO);

    void delete(Integer id);

    List<EnginePowerDTO> getAll();
}
