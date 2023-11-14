package com.coders.vehicle.service;

import com.coders.vehicle.dto.YearDTO;

import java.util.List;

public interface YearService {
    void save(YearDTO yearDTO);
    void update(Integer id, YearDTO yearDTO);
    void delete(Integer id);
    List<YearDTO> getAll();
}
