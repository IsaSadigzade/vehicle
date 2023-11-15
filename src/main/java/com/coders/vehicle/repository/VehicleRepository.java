package com.coders.vehicle.repository;

import com.coders.vehicle.entity.VehicleEntity;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<VehicleEntity, Integer> {
}
