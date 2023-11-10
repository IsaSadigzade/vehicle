package com.coders.vehicle.repository.impl;

import com.coders.vehicle.entity.FuelTypeEntity;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class FuelTypeRepositoryImpl
//        implements MyFuelTypeRepositoryMy
{
    private final Set<FuelTypeEntity> fuelTypeSet = new HashSet<>();

//    @Override
    public Set<FuelTypeEntity> getAll() {
        return fuelTypeSet;
    }

//    @Override
    public void save(FuelTypeEntity fuelType) {
        fuelTypeSet.add(fuelType);
    }

//    @Override
    public void update(Integer id, FuelTypeEntity fuelType) {
        for (FuelTypeEntity fT : fuelTypeSet) {
            if (fT.getId().equals(id)) {
                fT.setFuelTypeName(fuelType.getFuelTypeName());
            }
        }
    }

//    @Override
    public void delete(Integer id) {
        fuelTypeSet.removeIf(fT -> fT.getId().equals(id));
    }
}
