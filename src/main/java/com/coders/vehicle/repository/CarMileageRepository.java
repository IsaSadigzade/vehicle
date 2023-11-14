package com.coders.vehicle.repository;

import com.coders.vehicle.entity.CarMileageEntity;
import org.springframework.data.repository.CrudRepository;

public interface CarMileageRepository extends CrudRepository<CarMileageEntity, Integer> {
}
