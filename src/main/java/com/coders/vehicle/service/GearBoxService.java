package com.coders.vehicle.service;

import com.coders.vehicle.entity.GearBoxEntity;

import java.util.List;

public interface GearBoxService {
    void save(GearBoxEntity gearBox);
    void update(Integer id, GearBoxEntity gearBox);
    void delete(Integer id);
    List<GearBoxEntity> getAll();
}
