package com.coders.vehicle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarEquipmentDTO {
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
