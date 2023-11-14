package com.coders.vehicle.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarEquipmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean alloyWheels;
    private boolean abs;
    private boolean sunroof;
    private boolean rainSensor;
    private boolean centralLocking;
    private boolean parkingSensors;
    private boolean airConditioner;
    private boolean ventilatedSeats;
    private boolean leatherInterior;
    private boolean xenonLights;
    private boolean rearViewCamera;
    private boolean sideCurtains;
    private boolean heatedSeats;
}
