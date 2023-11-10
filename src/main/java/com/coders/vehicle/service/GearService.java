package com.coders.vehicle.service;

import com.coders.vehicle.entity.GearEntity;

import java.util.List;

public interface GearService {
    void save(GearEntity gear);
    void update(Integer id, GearEntity gear);
    void delete(Integer id);
    List<GearEntity> getAll();
}
