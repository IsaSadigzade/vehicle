package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.CarMileageDTO;
import com.coders.vehicle.entity.CarMileageEntity;
import com.coders.vehicle.repository.CarMileageRepository;
import com.coders.vehicle.service.CarMileageService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarMileageServiceImpl implements CarMileageService {
    private final CarMileageRepository carMileageRepository;

    @Autowired
    public CarMileageServiceImpl(CarMileageRepository carMileageRepository) {
        this.carMileageRepository = carMileageRepository;
    }

    @Override
    public void save(CarMileageDTO carMileageDTO) {
        carMileageRepository.save(toEntity(carMileageDTO));
    }

    @Override
    public void update(Integer id, CarMileageDTO carMileageDTO) {
        carMileageRepository.findById(id).ifPresent(entity -> carMileageRepository.save(toEntity(carMileageDTO)));
    }

    @Override
    public void delete(Integer id) {
        carMileageRepository.deleteById(id);
    }

    @Override
    public List<CarMileageDTO> getAll() {
        List<CarMileageEntity> entities = (List<CarMileageEntity>) carMileageRepository.findAll();
        List<CarMileageDTO> dtoList = new ArrayList<>();
        for (CarMileageEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Contract("_ -> new")
    public static @NotNull CarMileageDTO toDto(@NotNull CarMileageEntity entity) {
        return new CarMileageDTO(entity.getId(), entity.getMileageValue(), entity.getMileageUnit());
    }

    @Contract("_ -> new")
    public static @NotNull CarMileageEntity toEntity(@NotNull CarMileageDTO dto) {
        return new CarMileageEntity(dto.getId(), dto.getMileageValue(), dto.getMileageUnit());
    }
}
