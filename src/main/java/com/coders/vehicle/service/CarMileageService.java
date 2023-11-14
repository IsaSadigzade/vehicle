package com.coders.vehicle.service;

import com.coders.vehicle.dto.CarMileageDTO;

import java.util.List;

public interface CarMileageService {
    void save(CarMileageDTO carMileageDTO);

    void update(Integer id, CarMileageDTO carMileageDTO);

    void delete(Integer id);

    List<CarMileageDTO> getAll();
}
