package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.EngineCapacityDTO;
import com.coders.vehicle.entity.EngineCapacityEntity;
import com.coders.vehicle.repository.EngineCapacityRepository;
import com.coders.vehicle.service.EngineCapacityService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EngineCapacityServiceImpl implements EngineCapacityService {
    private final EngineCapacityRepository engineCapacityRepository;

    @Autowired
    public EngineCapacityServiceImpl(EngineCapacityRepository engineCapacityRepository) {
        this.engineCapacityRepository = engineCapacityRepository;
    }

    @Override
    public void save(EngineCapacityDTO engineCapacityDTO) {
        engineCapacityRepository.save(toEntity(engineCapacityDTO));
    }

    @Override
    public void update(Integer id, EngineCapacityDTO engineCapacityDTO) {
        engineCapacityRepository.findById(id).ifPresent(entity -> engineCapacityRepository.save(toEntity(engineCapacityDTO)));

    }

    @Override
    public void delete(Integer id) {
        engineCapacityRepository.deleteById(id);
    }

    @Override
    public List<EngineCapacityDTO> getAll() {
        List<EngineCapacityEntity> entities = (List<EngineCapacityEntity>) engineCapacityRepository.findAll();
        List<EngineCapacityDTO> dtoList = new ArrayList<>();
        for (EngineCapacityEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    public static @NotNull EngineCapacityDTO toDto(@NotNull EngineCapacityEntity entity) {
        return new EngineCapacityDTO(entity.getId(), entity.getCapacity());
    }

    public static @NotNull EngineCapacityEntity toEntity(@NotNull EngineCapacityDTO dto) {
        return new EngineCapacityEntity(dto.getId(), dto.getCapacity());
    }
}
