package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.CarEquipmentDTO;
import com.coders.vehicle.entity.CarEquipmentEntity;
import com.coders.vehicle.repository.CarEquipmentRepository;
import com.coders.vehicle.service.CarEquipmentService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarEquipmentServiceImpl implements CarEquipmentService {
    private final CarEquipmentRepository carEquipmentRepository;

    @Autowired
    public CarEquipmentServiceImpl(CarEquipmentRepository carEquipmentRepository) {
        this.carEquipmentRepository = carEquipmentRepository;
    }

    @Override
    public void save(CarEquipmentDTO carEquipmentDTO) {
        carEquipmentRepository.save(toEntity(carEquipmentDTO));
    }

    @Override
    public void update(Integer id, CarEquipmentDTO carEquipmentDTO) {
        carEquipmentRepository.findById(id).ifPresent(entity -> carEquipmentRepository.save(toEntity(carEquipmentDTO)));
    }

    @Override
    public void delete(Integer id) {
        carEquipmentRepository.deleteById(id);
    }

    @Override
    public List<CarEquipmentDTO> getAll() {
        List<CarEquipmentEntity> entities = (List<CarEquipmentEntity>) carEquipmentRepository.findAll();
        List<CarEquipmentDTO> dtoList = new ArrayList<>();
        for (CarEquipmentEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    @Contract("_ -> new")
    public static @NotNull CarEquipmentDTO toDto(@NotNull CarEquipmentEntity entity) {
        return new CarEquipmentDTO(
                entity.getId(),
                entity.isAlloyWheels(),
                entity.isAbs(),
                entity.isSunroof(),
                entity.isRainSensor(),
                entity.isCentralLocking(),
                entity.isParkingSensors(),
                entity.isAirConditioner(),
                entity.isVentilatedSeats(),
                entity.isLeatherInterior(),
                entity.isXenonLights(),
                entity.isRearViewCamera(),
                entity.isSideCurtains(),
                entity.isHeatedSeats()
        );
    }

    @Contract("_ -> new")
    public static @NotNull CarEquipmentEntity toEntity(@NotNull CarEquipmentDTO dto) {
        return new CarEquipmentEntity(
                dto.getId(),
                dto.isAlloyWheels(),
                dto.isAbs(),
                dto.isSunroof(),
                dto.isRainSensor(),
                dto.isCentralLocking(),
                dto.isParkingSensors(),
                dto.isAirConditioner(),
                dto.isVentilatedSeats(),
                dto.isLeatherInterior(),
                dto.isXenonLights(),
                dto.isRearViewCamera(),
                dto.isSideCurtains(),
                dto.isHeatedSeats()
        );
    }
}
