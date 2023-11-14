package com.coders.vehicle.service;

import com.coders.vehicle.dto.DescriptionDTO;

import java.util.List;

public interface DescriptionService {
    void save(DescriptionDTO descriptionDTO);
    void update(Integer id, DescriptionDTO descriptionDTO);
    void delete(Integer id);
    List<DescriptionDTO> getAll();
}
