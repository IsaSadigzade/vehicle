package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.FuelTypeDTO;
import com.coders.vehicle.entity.FuelTypeEntity;
import com.coders.vehicle.repository.FuelTypeRepository;
import com.coders.vehicle.service.FuelTypeService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
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

    @Contract("_ -> new")
    public static @NotNull FuelTypeDTO toDto(@NotNull FuelTypeEntity entity) {
        return new FuelTypeDTO(entity.getId(), entity.getFuelTypeName());
    }

    @Contract("_ -> new")
    public static @NotNull FuelTypeEntity toEntity(@NotNull FuelTypeDTO dto) {
        return new FuelTypeEntity(dto.getId(), dto.getFuelTypeName());
    }
}
