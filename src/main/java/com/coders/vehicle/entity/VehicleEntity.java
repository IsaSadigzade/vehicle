package com.coders.vehicle.entity;

import com.coders.vehicle.enums.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn
    private ModelEntity modelEntity;

    @ManyToOne
    @JoinColumn
    private VehicleTypeEntity vehicleTypeEntity;

    private BigDecimal mileageValue;
    private String mileageUnit;

    @ManyToOne
    @JoinColumn
    private ColourEntity colourEntity;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @ManyToOne
    @JoinColumn
    private CarOwnersEntity carOwnersEntity;

    @ManyToOne
    @JoinColumn
    private FuelTypeEntity fuelTypeEntity;

    @ManyToOne
    @JoinColumn
    private GearEntity gearEntity;

    @ManyToOne
    @JoinColumn
    private GearBoxEntity gearBoxEntity;

    @ManyToOne
    @JoinColumn
    private YearEntity yearEntity;

    @ManyToOne
    @JoinColumn
    private EngineCapacityEntity engineCapacityEntity;

    private Integer powerAmount;
    private String powerUnit;

    @ManyToOne
    @JoinColumn
    private CountryOfOriginEntity countryOfOriginEntity;

    private boolean hasDamage;
    private boolean isColourChanged;
    private boolean isCrashed;

    @ManyToOne
    @JoinColumn
    private NumberOfSeatsEntity numberOfSeatsEntity;

    private boolean hasCredit;
    private boolean isBarterPossible;

    private String vinCode;

    private String description;

    @ManyToOne
    @JoinColumn
    private CarEquipmentEntity carEquipmentEntity;

    @ManyToOne
    @JoinColumn
    private ImageEntity imageEntity;

    private String userName;

    @ManyToOne
    @JoinColumn
    private CityEntity cityEntity;

    private String email;
    private String phoneNumber;
}
