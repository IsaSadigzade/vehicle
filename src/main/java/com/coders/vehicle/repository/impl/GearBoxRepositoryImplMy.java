package com.coders.vehicle.repository.impl;

import com.coders.vehicle.entity.GearBoxEntity;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class GearBoxRepositoryImplMy
//        implements GearBoxRepository
{
    private final Set<GearBoxEntity> gearBoxSet = new HashSet<>();

//    @Override
    public void save(GearBoxEntity gearBox) {
        gearBoxSet.add(gearBox);
    }

//    @Override
    public void update(Integer id, GearBoxEntity gearBox) {
        for (GearBoxEntity gb : gearBoxSet) {
            if (gb.getId().equals(id)) {
                gb.setGearName(gearBox.getGearName());
            }
        }
    }

//    @Override
    public void delete(Integer id) {
        gearBoxSet.removeIf(gb -> gb.getId().equals(id));
    }

//    @Override
    public Set<GearBoxEntity> getAll() {
        return gearBoxSet;
    }
}
