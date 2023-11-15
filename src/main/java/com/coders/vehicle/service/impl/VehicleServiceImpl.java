package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.VehicleDTO;
import com.coders.vehicle.entity.VehicleEntity;
import com.coders.vehicle.repository.VehicleRepository;
import com.coders.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void save(VehicleDTO vehicleDTO) {
        vehicleRepository.save(toEntity(vehicleDTO));
    }

    @Override
    public void update(Integer id, VehicleDTO vehicleDTO) {
        vehicleRepository.findById(id).ifPresent(entity -> vehicleRepository.save(toEntity(vehicleDTO)));
    }

    @Override
    public void delete(Integer id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public List<VehicleDTO> getAll() {
        List<VehicleEntity> entities = (List<VehicleEntity>) vehicleRepository.findAll();
        List<VehicleDTO> dtoList = new ArrayList<>();
        for (VehicleEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    private VehicleDTO toDto(VehicleEntity entity) {
        return new VehicleDTO(
                entity.getId(),
                ModelServiceImpl.toDto(entity.getModelEntity()),
                VehicleTypeServiceImpl.toDto(entity.getVehicleTypeEntity()),
                entity.getMileageValue(),
                entity.getMileageUnit(),
                ColourServiceImpl.toDto(entity.getColourEntity()),
                entity.getAmount(),
                entity.getCurrency(),
                CarOwnersServiceImpl.toDto(entity.getCarOwnersEntity()),
                FuelTypeServiceImpl.toDto(entity.getFuelTypeEntity()),
                GearServiceImpl.toDto(entity.getGearEntity()),
                GearBoxServiceImpl.toDto(entity.getGearBoxEntity()),
                YearServiceImpl.toDto(entity.getYearEntity()),
                EngineCapacityServiceImpl.toDto(entity.getEngineCapacityEntity()),
                entity.getPowerAmount(),
                entity.getPowerUnit(),
                CountryOfOriginServiceImpl.toDto(entity.getCountryOfOriginEntity()),
                entity.isHasDamage(),
                entity.isColourChanged(),
                entity.isCrashed(),
                NumberOfSeatsServiceImpl.toDto(entity.getNumberOfSeatsEntity()),
                entity.isHasCredit(),
                entity.isBarterPossible(),
                entity.getVinCode(),
                entity.getDescription(),
                CarEquipmentServiceImpl.toDto(entity.getCarEquipmentEntity()),
                ImageServiceImpl.toDto(entity.getImageEntity()),
                entity.getUserName(),
                CityServiceImpl.toDto(entity.getCityEntity()),
                entity.getEmail(),
                entity.getPhoneNumber()
        );
    }

    private VehicleEntity toEntity(VehicleDTO dto) {
        return new VehicleEntity(
                dto.getId(),
                ModelServiceImpl.toEntity(dto.getModelDTO()),
                VehicleTypeServiceImpl.toEntity(dto.getVehicleTypeDTO()),
                dto.getMileageValue(),
                dto.getMileageUnit(),
                ColourServiceImpl.toEntity(dto.getColourDTO()),
                dto.getAmount(),
                dto.getCurrency(),
                CarOwnersServiceImpl.toEntity(dto.getCarOwnersDTO()),
                FuelTypeServiceImpl.toEntity(dto.getFuelTypeDTO()),
                GearServiceImpl.toEntity(dto.getGearDTO()),
                GearBoxServiceImpl.toEntity(dto.getGearBoxDTO()),
                YearServiceImpl.toEntity(dto.getYearDTO()),
                EngineCapacityServiceImpl.toEntity(dto.getEngineCapacityDTO()),
                dto.getPowerAmount(),
                dto.getPowerUnit(),
                CountryOfOriginServiceImpl.toEntity(dto.getCountryOfOriginDTO()),
                dto.isHasDamage(),
                dto.isColourChanged(),
                dto.isCrashed(),
                NumberOfSeatsServiceImpl.toEntity(dto.getNumberOfSeatsDTO()),
                dto.isHasCredit(),
                dto.isBarterPossible(),
                dto.getVinCode(),
                dto.getDescription(),
                CarEquipmentServiceImpl.toEntity(dto.getCarEquipmentDTO()),
                ImageServiceImpl.toEntity(dto.getImageDTO()),
                dto.getUserName(),
                CityServiceImpl.toEntity(dto.getCityDTO()),
                dto.getEmail(),
                dto.getPhoneNumber()
        );
    }
}
