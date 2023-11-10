package com.coders.vehicle.service.impl;

import com.coders.vehicle.entity.GearBoxEntity;
import com.coders.vehicle.repository.GearBoxRepository;
import com.coders.vehicle.service.GearBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GearBoxServiceImpl implements GearBoxService {
    @Autowired
    private GearBoxRepository gearBoxRepository;

    @Override
    public void save(GearBoxEntity gearBox) {
        gearBoxRepository.save(gearBox);
    }

    @Override
    public void update(Integer id, GearBoxEntity gearBox) {
        GearBoxEntity existingGearBox = gearBoxRepository.findById(id).orElse(null);
        if (existingGearBox != null) {
            existingGearBox.setGearName(gearBox.getGearName());
            gearBoxRepository.save(existingGearBox);
        }
    }

    @Override
    public void delete(Integer id) {
        gearBoxRepository.deleteById(id);
    }

    @Override
    public List<GearBoxEntity> getAll() {
        return (List<GearBoxEntity>) gearBoxRepository.findAll();
    }
}
