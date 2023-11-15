package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.CountryOfOriginDTO;
import com.coders.vehicle.entity.CountryOfOriginEntity;
import com.coders.vehicle.repository.CountryOfOriginRepository;
import com.coders.vehicle.service.CountryOfOriginService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryOfOriginServiceImpl implements CountryOfOriginService {
    private final CountryOfOriginRepository countryOfOriginRepository;

    @Autowired
    public CountryOfOriginServiceImpl(CountryOfOriginRepository countryOfOriginRepository) {
        this.countryOfOriginRepository = countryOfOriginRepository;
    }

    @Override
    public void save(CountryOfOriginDTO countryOfOriginDTO) {
        countryOfOriginRepository.save(toEntity(countryOfOriginDTO));
    }

    @Override
    public void update(Integer id, CountryOfOriginDTO countryOfOriginDTO) {
        countryOfOriginRepository.findById(id).ifPresent(entity -> countryOfOriginRepository.save(toEntity(countryOfOriginDTO)));
    }

    @Override
    public void delete(Integer id) {
        countryOfOriginRepository.deleteById(id);
    }

    @Override
    public List<CountryOfOriginDTO> getAll() {
        List<CountryOfOriginEntity> entities = (List<CountryOfOriginEntity>) countryOfOriginRepository.findAll();
        List<CountryOfOriginDTO> dtoList = new ArrayList<>();
        for (CountryOfOriginEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    public static @NotNull CountryOfOriginDTO toDto(@NotNull CountryOfOriginEntity entity) {
        return new CountryOfOriginDTO(entity.getId(), entity.getCountryName());
    }

    public static @NotNull CountryOfOriginEntity toEntity(@NotNull CountryOfOriginDTO dto) {
        return new CountryOfOriginEntity(dto.getId(), dto.getCountryName());
    }
}
