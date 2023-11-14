package com.coders.vehicle.service;

import com.coders.vehicle.dto.CreditAndBarterDTO;

import java.util.List;

public interface CreditAndBarterService {
    void save(CreditAndBarterDTO creditAndBarterDTO);

    void update(Integer id, CreditAndBarterDTO creditAndBarterDTO);

    void delete(Integer id);

    List<CreditAndBarterDTO> getAll();
}
