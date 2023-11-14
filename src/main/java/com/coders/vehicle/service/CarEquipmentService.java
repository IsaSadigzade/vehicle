package com.coders.vehicle.service;

import com.coders.vehicle.dto.CarEquipmentDTO;

import java.util.List;

public interface CarEquipmentService {
    void save(CarEquipmentDTO carEquipmentDTO);

    void update(Integer id, CarEquipmentDTO carEquipmentDTO);

    void delete(Integer id);

    List<CarEquipmentDTO> getAll();
}
