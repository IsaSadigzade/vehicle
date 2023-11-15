package com.coders.vehicle.service;

import com.coders.vehicle.dto.CityDTO;

import java.util.List;

public interface CityService {
    void save(CityDTO cityDTO);
    void update(Integer id, CityDTO cityDTO);
    void delete(Integer id);
    List<CityDTO> getAll();
}
