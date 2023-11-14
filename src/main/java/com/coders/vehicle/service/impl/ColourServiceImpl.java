package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.ColourDTO;
import com.coders.vehicle.entity.ColourEntity;
import com.coders.vehicle.repository.ColourRepository;
import com.coders.vehicle.service.ColourService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColourServiceImpl implements ColourService {
    private final ColourRepository colourRepository;

    @Autowired
    public ColourServiceImpl(ColourRepository colourRepository) {
        this.colourRepository = colourRepository;
    }

    @Override
    public void save(ColourDTO colourDTO) {
        colourRepository.save(toEntity(colourDTO));
    }

    @Override
    public void update(Integer id, ColourDTO colourDTO) {
        colourRepository.findById(id).ifPresent(entity -> colourRepository.save(toEntity(colourDTO)));
    }

    @Override
    public void delete(Integer id) {
        colourRepository.deleteById(id);
    }

    @Override
    public List<ColourDTO> getAll() {
        List<ColourEntity> entities = (List<ColourEntity>) colourRepository.findAll();
        List<ColourDTO> dtoList = new ArrayList<>();
        for (ColourEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Contract("_ -> new")
    private @NotNull ColourDTO toDto(@NotNull ColourEntity entity) {
        return new ColourDTO(entity.getId(), entity.getColourName());
    }

    @Contract("_ -> new")
    private @NotNull ColourEntity toEntity(@NotNull ColourDTO dto) {
        return new ColourEntity(dto.getId(), dto.getColourName());
    }
}
