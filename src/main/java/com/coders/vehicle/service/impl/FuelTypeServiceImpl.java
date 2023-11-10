package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.FuelTypeDTO;
import com.coders.vehicle.entity.FuelTypeEntity;
import com.coders.vehicle.repository.FuelTypeRepository;
import com.coders.vehicle.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuelTypeServiceImpl implements FuelTypeService {

    private final FuelTypeRepository fuelTypeRepository;

    @Autowired
    public FuelTypeServiceImpl(FuelTypeRepository fuelTypeRepository) {
        this.fuelTypeRepository = fuelTypeRepository;
    }

    @Override
    public List<FuelTypeDTO> getAll() {
        List<FuelTypeEntity> entities = (List<FuelTypeEntity>) fuelTypeRepository.findAll();
        List<FuelTypeDTO> dtoList = new ArrayList<>();
        for (FuelTypeEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Override
    public void save(FuelTypeDTO fuelTypeDTO) {
        fuelTypeRepository.save(toEntity(fuelTypeDTO));
    }

    @Override
    public void update(Integer id, FuelTypeDTO fuelTypeDTO) {
        fuelTypeRepository.findById(id).ifPresent(entity -> fuelTypeRepository.save(toEntity(fuelTypeDTO)));
    }

    @Override
    public void delete(Integer id) {
        fuelTypeRepository.deleteById(id);
    }

    private FuelTypeDTO toDto(FuelTypeEntity entity) {
        FuelTypeDTO dto = new FuelTypeDTO();
        dto.setId(entity.getId());
        dto.setFuelTypeName(entity.getFuelTypeName());
        return dto;
    }

    private FuelTypeEntity toEntity(FuelTypeDTO dto) {
        FuelTypeEntity entity = new FuelTypeEntity();
        entity.setId(dto.getId());
        entity.setFuelTypeName(dto.getFuelTypeName());
        return entity;
    }
}
