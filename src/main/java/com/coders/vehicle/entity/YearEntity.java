package com.coders.vehicle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class YearEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Integer id;

//    @Column(name = "year")
    private Year yearOfVehicle;
}
