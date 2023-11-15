package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.CityDTO;
import com.coders.vehicle.entity.CityEntity;
import com.coders.vehicle.repository.CityRepository;
import com.coders.vehicle.service.CityService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void save(CityDTO cityDTO) {
        cityRepository.save(toEntity(cityDTO));
    }

    @Override
    public void update(Integer id, CityDTO cityDTO) {
        cityRepository.findById(id).ifPresent(entity -> cityRepository.save(toEntity(cityDTO)));
    }

    @Override
    public void delete(Integer id) {
        cityRepository.deleteById(id);
    }

    @Override
    public List<CityDTO> getAll() {
        List<CityEntity> entities = (List<CityEntity>) cityRepository.findAll();
        List<CityDTO> dtoList = new ArrayList<>();
        for (CityEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Contract("_ -> new")
    public static @NotNull CityDTO toDto(@NotNull CityEntity entity) {
        return new CityDTO(entity.getId(), entity.getCityName());
    }

    @Contract("_ -> new")
    public static @NotNull CityEntity toEntity(@NotNull CityDTO dto) {
        return new CityEntity(dto.getId(), dto.getCityName());
    }
}
