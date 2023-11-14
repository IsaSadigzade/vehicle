package com.coders.vehicle.service;

import com.coders.vehicle.dto.VehicleTypeDTO;

import java.util.List;

public interface VehicleTypeService {
    void save(VehicleTypeDTO vehicleTypeDTO);
    void update(Integer id, VehicleTypeDTO vehicleTypeDTO);
    void delete(Integer id);
    List<VehicleTypeDTO> getAll();
}
