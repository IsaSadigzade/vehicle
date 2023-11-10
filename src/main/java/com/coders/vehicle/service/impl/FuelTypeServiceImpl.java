package com.coders.vehicle.service.impl;

import com.coders.vehicle.entity.FuelTypeEntity;
import com.coders.vehicle.repository.FuelTypeRepository;
import com.coders.vehicle.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelTypeServiceImpl implements FuelTypeService {

    private final FuelTypeRepository fuelTypeRepository;

    @Autowired
    public FuelTypeServiceImpl(FuelTypeRepository fuelTypeRepository) {
        this.fuelTypeRepository = fuelTypeRepository;
    }

    @Override
    public List<FuelTypeEntity> getAll() {
        return (List<FuelTypeEntity>) fuelTypeRepository.findAll();
    }

    @Override
    public void save(FuelTypeEntity fuelType) {
        fuelTypeRepository.save(fuelType);
    }

    @Override
    public void update(Integer id, FuelTypeEntity fuelType) {
        FuelTypeEntity existingFuelType = fuelTypeRepository.findById(id).orElse(null);
        if (existingFuelType != null) {
            existingFuelType.setFuelTypeName(fuelType.getFuelTypeName());
            fuelTypeRepository.save(existingFuelType);
        }
    }

    @Override
    public void delete(Integer id) {
        fuelTypeRepository.deleteById(id);
    }
}
