package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.GearBoxDTO;
import com.coders.vehicle.entity.GearBoxEntity;
import com.coders.vehicle.repository.GearBoxRepository;
import com.coders.vehicle.service.GearBoxService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GearBoxServiceImpl implements GearBoxService {
    private final GearBoxRepository gearBoxRepository;

    @Autowired
    public GearBoxServiceImpl(GearBoxRepository gearBoxRepository) {
        this.gearBoxRepository = gearBoxRepository;
    }

    @Override
    public List<GearBoxDTO> getAll() {
        List<GearBoxEntity> entities = (List<GearBoxEntity>) gearBoxRepository.findAll();
        List<GearBoxDTO> dtoList = new ArrayList<>();
        for (GearBoxEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Override
    public void save(GearBoxDTO gearBoxDTO) {
        gearBoxRepository.save(toEntity(gearBoxDTO));
    }

    @Override
    public void update(Integer id, GearBoxDTO gearBoxDTO) {
        gearBoxRepository.findById(id).ifPresent(existingGearBox -> gearBoxRepository.save(toEntity(gearBoxDTO)));
    }

    @Override
    public void delete(Integer id) {
        gearBoxRepository.deleteById(id);
    }



    @Contract("_ -> new")
    public static @NotNull GearBoxDTO toDto(@NotNull GearBoxEntity entity) {
        return new GearBoxDTO(entity.getId(), entity.getGearName());
    }

    @Contract("_ -> new")
    public static @NotNull GearBoxEntity toEntity(@NotNull GearBoxDTO dto) {
        return new GearBoxEntity(dto.getId(), dto.getGearName());
    }
}
