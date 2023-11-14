package com.coders.vehicle.service;

import com.coders.vehicle.dto.PriceDTO;
import com.coders.vehicle.dto.YearDTO;

import java.util.List;

public interface PriceService {
    void save(PriceDTO priceDTO);
    void update(Integer id, PriceDTO priceDTO);
    void delete(Integer id);
    List<PriceDTO> getAll();
}
