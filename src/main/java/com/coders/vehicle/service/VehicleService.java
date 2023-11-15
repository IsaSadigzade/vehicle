package com.coders.vehicle.service;

import com.coders.vehicle.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void save(VehicleDTO vehicleDTO);
    void update(Integer id, VehicleDTO vehicleDTO);
    void delete(Integer id);
    List<VehicleDTO> getAll();
}
