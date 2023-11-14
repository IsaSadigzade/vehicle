package com.coders.vehicle.entity;

import com.coders.vehicle.enums.City;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private City city;
    private String email;
    private String phoneNumber;
}
