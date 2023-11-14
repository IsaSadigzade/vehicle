package com.coders.vehicle.repository;

import com.coders.vehicle.entity.VehicleStatusEntity;
import org.springframework.data.repository.CrudRepository;

public interface VehicleStatusRepository extends CrudRepository<VehicleStatusEntity, Integer> {
}
