package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.VehicleStatusDTO;
import com.coders.vehicle.entity.VehicleStatusEntity;
import com.coders.vehicle.repository.VehicleStatusRepository;
import com.coders.vehicle.service.VehicleStatusService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleStatusServiceImpl implements VehicleStatusService {

    private final VehicleStatusRepository vehicleStatusRepository;

    @Autowired
    public VehicleStatusServiceImpl(VehicleStatusRepository vehicleStatusRepository) {
        this.vehicleStatusRepository = vehicleStatusRepository;
    }

    @Override
    public void save(VehicleStatusDTO vehicleStatusDTO) {
        vehicleStatusRepository.save(toEntity(vehicleStatusDTO));
    }

    @Override
    public void update(Integer id, VehicleStatusDTO vehicleStatusDTO) {
        vehicleStatusRepository.findById(id).ifPresent(entity -> vehicleStatusRepository.save(toEntity(vehicleStatusDTO)));
    }

    @Override
    public void delete(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }

    @Override
    public List<VehicleStatusDTO> getAll() {
        List<VehicleStatusEntity> entities = (List<VehicleStatusEntity>) vehicleStatusRepository.findAll();
        List<VehicleStatusDTO> dtoList = new ArrayList<>();
        for (VehicleStatusEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Contract("_ -> new")
    private @NotNull VehicleStatusDTO toDto(@NotNull VehicleStatusEntity entity) {
        return new VehicleStatusDTO(entity.getId(), entity.isHasDamage(), entity.isColourChanged(), entity.isCrashed());
    }

    @Contract("_ -> new")
    private @NotNull VehicleStatusEntity toEntity(@NotNull VehicleStatusDTO dto) {
        return new VehicleStatusEntity(dto.getId(), dto.isHasDamage(), dto.isColourChanged(), dto.isCrashed());
    }
}
