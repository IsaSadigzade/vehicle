package com.coders.vehicle.service;

import com.coders.vehicle.dto.FuelTypeDTO;

import java.util.List;

public interface FuelTypeService {
    void save(FuelTypeDTO fuelTypeDTO);

    void update(Integer id, FuelTypeDTO fuelTypeDTO);

    void delete(Integer id);

    List<FuelTypeDTO> getAll();
}
