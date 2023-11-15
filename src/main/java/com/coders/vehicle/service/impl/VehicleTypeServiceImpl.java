package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.VehicleTypeDTO;
import com.coders.vehicle.entity.VehicleTypeEntity;
import com.coders.vehicle.repository.VehicleTypeRepository;
import com.coders.vehicle.service.VehicleTypeService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {
    private final VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    public VehicleTypeServiceImpl(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }


    @Override
    public void save(VehicleTypeDTO vehicleTypeDTO) {
        vehicleTypeRepository.save(toEntity(vehicleTypeDTO));
    }

    @Override
    public void update(Integer id, VehicleTypeDTO vehicleTypeDTO) {
        vehicleTypeRepository.findById(id).ifPresent(entity -> vehicleTypeRepository.save(toEntity(vehicleTypeDTO)));
    }

    @Override
    public void delete(Integer id) {
        vehicleTypeRepository.deleteById(id);
    }

    @Override
    public List<VehicleTypeDTO> getAll() {
        List<VehicleTypeEntity> entities = (List<VehicleTypeEntity>) vehicleTypeRepository.findAll();
        List<VehicleTypeDTO> dtoList = new ArrayList<>();
        for (VehicleTypeEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Contract("_ -> new")
    public static @NotNull VehicleTypeDTO toDto(@NotNull VehicleTypeEntity entity) {
        return new VehicleTypeDTO(entity.getId(), entity.getVehicleType());
    }

    @Contract("_ -> new")
    public static @NotNull VehicleTypeEntity toEntity(@NotNull VehicleTypeDTO dto) {
        return new VehicleTypeEntity(dto.getId(), dto.getVehicleType());
    }
}
