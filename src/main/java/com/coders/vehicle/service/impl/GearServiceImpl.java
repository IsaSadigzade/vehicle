package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.GearDTO;
import com.coders.vehicle.entity.GearEntity;
import com.coders.vehicle.repository.GearRepository;
import com.coders.vehicle.service.GearService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
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

    @Contract("_ -> new")
    public static @NotNull GearDTO toDto(@NotNull GearEntity entity) {
        return new GearDTO(entity.getId(), entity.getGearType());
    }

    @Contract("_ -> new")
    public static @NotNull GearEntity toEntity(@NotNull GearDTO dto) {
        return new GearEntity(dto.getId(), dto.getGearType());
    }
}
