package com.coders.vehicle.repository;

import com.coders.vehicle.entity.NumberOfSeatsEntity;
import org.springframework.data.repository.CrudRepository;

public interface NumberOfSeatsRepository extends CrudRepository<NumberOfSeatsEntity, Integer> {
}
