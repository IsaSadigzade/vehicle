package com.coders.vehicle.service;

import com.coders.vehicle.dto.VehicleStatusDTO;

import java.util.List;

public interface VehicleStatusService {
    void save(VehicleStatusDTO vehicleStatusDTO);

    void update(Integer id, VehicleStatusDTO vehicleStatusDTO);

    void delete(Integer id);

    List<VehicleStatusDTO> getAll();
}
