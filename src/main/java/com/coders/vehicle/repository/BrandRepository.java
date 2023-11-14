package com.coders.vehicle.repository;

import com.coders.vehicle.entity.BrandEntity;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<BrandEntity, Integer> {
}
