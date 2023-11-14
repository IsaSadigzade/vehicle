package com.coders.vehicle.repository;

import com.coders.vehicle.entity.PriceEntity;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<PriceEntity, Integer> {
}
