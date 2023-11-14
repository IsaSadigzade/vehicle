package com.coders.vehicle.service;

import com.coders.vehicle.dto.CountryOfOriginDTO;

import java.util.List;

public interface CountryOfOriginService {
    void save(CountryOfOriginDTO countryOfOriginDTO);

    void update(Integer id, CountryOfOriginDTO countryOfOriginDTO);

    void delete(Integer id);

    List<CountryOfOriginDTO> getAll();
}
