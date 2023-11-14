package com.coders.vehicle.service;

import com.coders.vehicle.dto.ColourDTO;

import java.util.List;

public interface ColourService {
    void save(ColourDTO colourDTO);
    void update(Integer id, ColourDTO colourDTO);
    void delete(Integer id);
    List<ColourDTO> getAll();
}
