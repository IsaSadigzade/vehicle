package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.EnginePowerDTO;
import com.coders.vehicle.entity.EnginePowerEntity;
import com.coders.vehicle.repository.EnginePowerRepository;
import com.coders.vehicle.service.EnginePowerService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnginePowerServiceImpl implements EnginePowerService {
    private final EnginePowerRepository enginePowerRepository;

    @Autowired
    public EnginePowerServiceImpl(EnginePowerRepository enginePowerRepository) {
        this.enginePowerRepository = enginePowerRepository;
    }

    @Override
    public void save(EnginePowerDTO enginePowerDTO) {
        enginePowerRepository.save(toEntity(enginePowerDTO));
    }

    @Override
    public void update(Integer id, EnginePowerDTO enginePowerDTO) {
        enginePowerRepository.findById(id).ifPresent(entity -> enginePowerRepository.save(toEntity(enginePowerDTO)));
    }

    @Override
    public void delete(Integer id) {
        enginePowerRepository.deleteById(id);
    }

    @Override
    public List<EnginePowerDTO> getAll() {
        List<EnginePowerEntity> entities = (List<EnginePowerEntity>) enginePowerRepository.findAll();
        List<EnginePowerDTO> dtoList = new ArrayList<>();
        for (EnginePowerEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    private EnginePowerDTO toDto(@NotNull EnginePowerEntity entity) {
        EnginePowerDTO dto = new EnginePowerDTO();
        dto.setId(entity.getId());
        dto.setPowerAmount(entity.getPowerAmount());
        dto.setPowerUnit(entity.getPowerUnit());
        return dto;
    }

    private EnginePowerEntity toEntity(@NotNull EnginePowerDTO dto) {
        EnginePowerEntity entity = new EnginePowerEntity();
        entity.setId(dto.getId());
        entity.setPowerAmount(dto.getPowerAmount());
        entity.setPowerUnit(dto.getPowerUnit());
        return entity;
    }
}
