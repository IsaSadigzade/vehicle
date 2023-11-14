package com.coders.vehicle.repository;

import com.coders.vehicle.entity.CarOwnersEntity;
import org.springframework.data.repository.CrudRepository;

public interface CarOwnersRepository extends CrudRepository<CarOwnersEntity, Integer> {
}
