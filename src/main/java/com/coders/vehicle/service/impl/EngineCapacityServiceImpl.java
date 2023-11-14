package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.EngineCapacityDTO;
import com.coders.vehicle.entity.EngineCapacityEntity;
import com.coders.vehicle.repository.EngineCapacityRepository;
import com.coders.vehicle.service.EngineCapacityService;
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

    private EngineCapacityDTO toDto(EngineCapacityEntity entity) {
        EngineCapacityDTO dto = new EngineCapacityDTO();
        dto.setId(entity.getId());
        dto.setCapacity(entity.getCapacity());
        return dto;
    }

    private EngineCapacityEntity toEntity(EngineCapacityDTO dto) {
        EngineCapacityEntity entity = new EngineCapacityEntity();
        entity.setId(dto.getId());
        entity.setCapacity(dto.getCapacity());
        return entity;
    }
}
