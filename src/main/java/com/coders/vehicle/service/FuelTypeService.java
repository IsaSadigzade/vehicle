package com.coders.vehicle.service;

import com.coders.vehicle.entity.FuelTypeEntity;

import java.util.List;

public interface FuelTypeService {
    void save(FuelTypeEntity fuelType);

    void update(Integer id, FuelTypeEntity fuelType);

    void delete(Integer id);

    List<FuelTypeEntity> getAll();
}
