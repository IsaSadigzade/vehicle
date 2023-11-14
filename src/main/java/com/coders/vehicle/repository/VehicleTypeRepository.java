package com.coders.vehicle.repository;

import com.coders.vehicle.entity.VehicleTypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface VehicleTypeRepository extends CrudRepository<VehicleTypeEntity, Integer> {
}
