package com.coders.vehicle.service.impl;

import com.coders.vehicle.entity.GearEntity;
import com.coders.vehicle.repository.GearRepository;
import com.coders.vehicle.service.GearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GearServiceImpl implements GearService {

    @Autowired
    private GearRepository gearRepository;

    @Override
    public void save(GearEntity gear) {
        gearRepository.save(gear);
    }

    @Override
    public void update(Integer id, GearEntity gear) {
        GearEntity existingGear = gearRepository.findById(id).orElse(null);
        if (existingGear != null) {
            existingGear.setGearType(gear.getGearType());
            gearRepository.save(existingGear);
        }
    }

    @Override
    public void delete(Integer id) {
        gearRepository.deleteById(id);
    }

    @Override
    public List<GearEntity> getAll() {
        return (List<GearEntity>) gearRepository.findAll();
    }
}
