package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.NumberOfSeatsDTO;
import com.coders.vehicle.entity.NumberOfSeatsEntity;
import com.coders.vehicle.repository.NumberOfSeatsRepository;
import com.coders.vehicle.service.NumberOfSeatsService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumberOfSeatsServiceImpl implements NumberOfSeatsService {
    private final NumberOfSeatsRepository numberOfSeatsRepository;

    @Autowired
    public NumberOfSeatsServiceImpl(NumberOfSeatsRepository numberOfSeatsRepository) {
        this.numberOfSeatsRepository = numberOfSeatsRepository;
    }

    @Override
    public void save(NumberOfSeatsDTO numberOfSeatsDTO) {
        numberOfSeatsRepository.save(toEntity(numberOfSeatsDTO));
    }

    @Override
    public void update(Integer id, NumberOfSeatsDTO numberOfSeatsDTO) {
        numberOfSeatsRepository.findById(id).ifPresent(entity -> numberOfSeatsRepository.save(toEntity(numberOfSeatsDTO)));
    }

    @Override
    public void delete(Integer id) {
        numberOfSeatsRepository.deleteById(id);
    }

    @Override
    public List<NumberOfSeatsDTO> getAll() {
        List<NumberOfSeatsEntity> entities = (List<NumberOfSeatsEntity>) numberOfSeatsRepository.findAll();
        List<NumberOfSeatsDTO> dtoList = new ArrayList<>();
        for (NumberOfSeatsEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Contract("_ -> new")
    private @NotNull NumberOfSeatsDTO toDto(@NotNull NumberOfSeatsEntity entity) {
        return new NumberOfSeatsDTO(entity.getId(), entity.getNumberOfSeats());
    }

    @Contract("_ -> new")
    private @NotNull NumberOfSeatsEntity toEntity(@NotNull NumberOfSeatsDTO dto) {
        return new NumberOfSeatsEntity(dto.getId(), dto.getNumberOfSeats());
    }
}
