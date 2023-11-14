package com.coders.vehicle.service.impl;

import com.coders.vehicle.dto.CarOwnersDTO;
import com.coders.vehicle.entity.CarOwnersEntity;
import com.coders.vehicle.repository.CarOwnersRepository;
import com.coders.vehicle.service.CarOwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarOwnersServiceImpl implements CarOwnersService {
    private final CarOwnersRepository carOwnersRepository;

    @Autowired
    public CarOwnersServiceImpl(CarOwnersRepository carOwnersRepository) {
        this.carOwnersRepository = carOwnersRepository;
    }

    @Override
    public void save(CarOwnersDTO carOwnersDTO) {
        carOwnersRepository.save(toEntity(carOwnersDTO));
    }

    @Override
    public void update(Integer id, CarOwnersDTO carOwnersDTO) {
        carOwnersRepository.findById(id).ifPresent(entity -> carOwnersRepository.save(toEntity(carOwnersDTO)));
    }

    @Override
    public void delete(Integer id) {
        carOwnersRepository.deleteById(id);
    }

    @Override
    public List<CarOwnersDTO> getAll() {
        List<CarOwnersEntity> entities = (List<CarOwnersEntity>) carOwnersRepository.findAll();
        List<CarOwnersDTO> dtoList = new ArrayList<>();
        for (CarOwnersEntity e : entities) {
            dtoList.add(toDto(e));
        }
        return dtoList;
    }

    private CarOwnersDTO toDto(CarOwnersEntity entity) {
        return new CarOwnersDTO(entity.getId(), entity.getWhichOwnerOfCar());
    }

    private CarOwnersEntity toEntity(CarOwnersDTO dto) {
        return new CarOwnersEntity(dto.getId(), dto.getWhichOwnerOfCar());
    }
}
