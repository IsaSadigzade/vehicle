package com.coders.vehicle.repository;

import com.coders.vehicle.entity.BrandEntity;
import com.coders.vehicle.entity.ModelEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModelRepository extends CrudRepository<ModelEntity, Integer> {
    ModelEntity findByModelName(String modelName);
    ModelEntity findByModelNameIgnoreCase(String modelName);
    List<ModelEntity> findAllByBrandEntity(BrandEntity entity);
}
