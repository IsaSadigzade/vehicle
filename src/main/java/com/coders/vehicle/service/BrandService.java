package com.coders.vehicle.service;

import com.coders.vehicle.dto.BrandDTO;

import java.util.List;

public interface BrandService {
    void save(BrandDTO brandDTO);
    void update(Integer id, BrandDTO brandDTO);
    void delete(Integer id);
    List<BrandDTO> getAll();
}
