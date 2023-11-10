package com.coders.vehicle.repository.impl;

import com.coders.vehicle.entity.GearEntity;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class GearRepositoryImpl
//        implements GearRepository
{
    private final Set<GearEntity> gearSet = new HashSet<>();

    //    @Override
    public void save(GearEntity gear) {
        gearSet.add(gear);
    }

    //    @Override
    public void update(Integer id, GearEntity gear) {
        for (GearEntity g : gearSet) {
            if (g.getId().equals(id)) {
                g.setGearType(gear.getGearType());
            }
        }
    }

    //    @Override
    public void delete(Integer id) {
        gearSet.removeIf(g -> g.getId().equals(id));
    }

    //    @Override
    public Set<GearEntity> getAll() {
        return gearSet;
    }
}
