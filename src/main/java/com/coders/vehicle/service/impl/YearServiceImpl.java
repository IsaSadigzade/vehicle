package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.YearDTO;
import com.coders.vehicle.entity.YearEntity;
import com.coders.vehicle.repository.YearRepository;
import com.coders.vehicle.service.YearService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YearServiceImpl implements YearService {
    private final YearRepository yearRepository;

    @Autowired
    public YearServiceImpl(YearRepository yearRepository) {
        this.yearRepository = yearRepository;
    }


    @Override
    public void save(YearDTO yearDTO) {
        yearRepository.save(toEntity(yearDTO));
    }

    @Override
    public void update(Integer id, YearDTO yearDTO) {
        yearRepository.findById(id).ifPresent(entity -> yearRepository.save(toEntity(yearDTO)));
    }

    @Override
    public void delete(Integer id) {
        yearRepository.deleteById(id);
    }

    @Override
    public List<YearDTO> getAll() {
        List<YearEntity> entities = (List<YearEntity>) yearRepository.findAll();
        List<YearDTO> dtoList = new ArrayList<>();
        for (YearEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Contract("_ -> new")
    public static @NotNull YearDTO toDto(@NotNull YearEntity entity) {
        return new YearDTO(entity.getId(), entity.getYearOfVehicle());
    }

    @Contract("_ -> new")
    public static @NotNull YearEntity toEntity(@NotNull YearDTO dto) {
        return new YearEntity(dto.getId(), dto.getYearOfVehicle());
    }
}
