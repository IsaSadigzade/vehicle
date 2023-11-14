package com.coders.vehicle.dto;

import com.coders.vehicle.enums.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    private Integer id;
    private String name;
    private City city;
    private String email;
    private String phoneNumber;
}
