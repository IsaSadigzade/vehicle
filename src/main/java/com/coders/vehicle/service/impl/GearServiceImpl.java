package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.GearDTO;
import com.coders.vehicle.entity.GearEntity;
import com.coders.vehicle.repository.GearRepository;
import com.coders.vehicle.service.GearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GearServiceImpl implements GearService {

    private final GearRepository gearRepository;

    @Autowired
    public GearServiceImpl(GearRepository gearRepository) {
        this.gearRepository = gearRepository;
    }

    @Override
    public void save(GearDTO gearDTO) {
        gearRepository.save(toEntity(gearDTO));
    }

    @Override
    public void update(Integer id, GearDTO gearDTO) {
        gearRepository.findById(id).ifPresent(existingGear -> gearRepository.save(toEntity(gearDTO)));
    }

    @Override
    public void delete(Integer id) {
        gearRepository.deleteById(id);
    }

    @Override
    public List<GearDTO> getAll() {
        List<GearEntity> entities = (List<GearEntity>) gearRepository.findAll();
        List<GearDTO> dtoList = new ArrayList<>();
        for (GearEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    private GearDTO toDto(GearEntity entity) {
        GearDTO dto = new GearDTO();
        dto.setId(entity.getId());
        dto.setGearType(entity.getGearType());
        return dto;
    }

    private GearEntity toEntity(GearDTO dto) {
        GearEntity entity = new GearEntity();
        entity.setId(dto.getId());
        entity.setGearType(dto.getGearType());
        return entity;
    }
}
