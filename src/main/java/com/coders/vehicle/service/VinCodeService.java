package com.coders.vehicle.service;

import com.coders.vehicle.dto.VinCodeDTO;

import java.util.List;

public interface VinCodeService {
    void save(VinCodeDTO vinCodeDTO);

    void update(Integer id, VinCodeDTO vinCodeDTO);

    void delete(Integer id);

    List<VinCodeDTO> getAll();
}
