package com.coders.vehicle.repository;

import com.coders.vehicle.entity.ModelEntity;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository extends CrudRepository<ModelEntity, Integer> {
}
