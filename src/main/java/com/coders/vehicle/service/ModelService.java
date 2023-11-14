package com.coders.vehicle.service;

import com.coders.vehicle.dto.ModelDTO;

import java.util.List;

public interface ModelService {
    void save(ModelDTO modelDTO);
    void update(Integer id, ModelDTO modelDTO);
    void delete(Integer id);
    List<ModelDTO> getAll();
}
