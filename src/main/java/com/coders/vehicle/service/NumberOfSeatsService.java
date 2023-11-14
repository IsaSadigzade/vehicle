package com.coders.vehicle.service;

import com.coders.vehicle.dto.NumberOfSeatsDTO;

import java.util.List;

public interface NumberOfSeatsService {
    void save(NumberOfSeatsDTO numberOfSeatsDTO);

    void update(Integer id, NumberOfSeatsDTO numberOfSeatsDTO);

    void delete(Integer id);

    List<NumberOfSeatsDTO> getAll();
}
