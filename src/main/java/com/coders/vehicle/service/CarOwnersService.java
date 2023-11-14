package com.coders.vehicle.service;

import com.coders.vehicle.dto.CarOwnersDTO;

import java.util.List;

public interface CarOwnersService {
    void save(CarOwnersDTO carOwnersDTO);

    void update(Integer id, CarOwnersDTO carOwnersDTO);

    void delete(Integer id);

    List<CarOwnersDTO> getAll();
}
