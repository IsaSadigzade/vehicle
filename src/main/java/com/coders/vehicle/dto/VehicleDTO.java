package com.coders.vehicle.dto;

import com.coders.vehicle.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private Integer id;
    private ModelDTO modelDTO;
    private VehicleTypeDTO vehicleTypeDTO;
    private BigDecimal mileageValue;
    private String mileageUnit;
    private ColourDTO colourDTO;
    private BigDecimal amount;
    private Currency currency;
    private CarOwnersDTO carOwnersDTO;
    private FuelTypeDTO fuelTypeDTO;
    private GearDTO gearDTO;
    private GearBoxDTO gearBoxDTO;
    private YearDTO yearDTO;
    private EngineCapacityDTO engineCapacityDTO;
    private Integer powerAmount;
    private String powerUnit;
    private CountryOfOriginDTO countryOfOriginDTO;
    private boolean hasDamage;
    private boolean isColourChanged;
    private boolean isCrashed;
    private NumberOfSeatsDTO numberOfSeatsDTO;
    private boolean hasCredit;
    private boolean isBarterPossible;
    private String vinCode;
    private String description;
    private CarEquipmentDTO carEquipmentDTO;
    private ImageDTO imageDTO;
    private String userName;
    private CityDTO cityDTO;
    private String email;
    private String phoneNumber;
}
